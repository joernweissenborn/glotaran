package org.glotaran.analysiscore;

import akka.actor.UntypedActor;
import org.glotaran.analysiscore.interfaces.Analysis;

public class Worker extends UntypedActor {


    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Analysis) {
            ((Analysis) msg).Finished.complete(((Analysis) msg).Analyse());
            getSender().tell(Supervisor.Msg.DONE, getSelf());
        } else
            unhandled(msg);
    }

}