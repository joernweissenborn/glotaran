package org.glotaran.analysiscore;

/**
 * Created by joern on 6/10/2015.
 */

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import org.glotaran.analysiscore.interfaces.Analysis;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Supervisor extends UntypedActor {

    int nrWorker;

    Queue<Analysis> pending = new LinkedTransferQueue<>();

    Queue<ActorRef> idleWorker;

    Supervisor(int nrOfWorker) {
        nrWorker = nrOfWorker;
    }

    /**
     * Create Props for an actor of this type.
     * @param nrOfWorker The number of workers.
     * @return a Props for creating this actor, which can then be further configured
     *         (e.g. calling `.withDispatcher()` on it)
     */
    public static Props props(final int nrOfWorker) {
        return Props.create(new Creator<Supervisor>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Supervisor create() throws Exception {
                return new Supervisor(nrOfWorker);
            }
        });
    }

    public static enum Msg {
        DONE;
    }

    @Override
    public void preStart() {
        System.out.println(nrWorker);
        idleWorker = new ArrayBlockingQueue<ActorRef>(nrWorker);
        for (int i =0;i<nrWorker;i++){
            idleWorker.add(getContext().actorOf(Props.create(Worker.class), "worker"+i));
        }
    }

    @Override
    public void onReceive(Object msg) {
        System.out.println(msg);
        if (msg == Msg.DONE) {
            if (!pending.isEmpty()) {
                getSender().tell(pending.poll(),getSelf());
            } else {
                idleWorker.add(getSender());
            }
        } else if (msg instanceof Analysis) {
            if (workerFree()){
                doAnalysis((Analysis) msg);
            } else {
                pending.add((Analysis) msg);
            }
        } else {
            unhandled(msg);
        }
    }

    public  boolean workerFree(){
        return !idleWorker.isEmpty();
    }

    private void doAnalysis(Analysis ana){
        idleWorker.poll().tell(ana, getSelf());
    }

}