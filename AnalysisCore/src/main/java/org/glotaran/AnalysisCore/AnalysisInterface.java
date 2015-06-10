package org.glotaran.analysiscore;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import org.glotaran.analysiscore.interfaces.Analysis;

/**
 * Created by joern on 6/10/2015.
 */
public class AnalysisInterface {

    private final ActorSystem system = ActorSystem.create("System");
    private ActorRef supervisor;

    AnalysisInterface(int nrWorkers){
        supervisor = system.actorOf(Supervisor.props(nrWorkers), Supervisor.class.getName());
    }

    public void doAnalysis(Analysis ana) {
        supervisor.tell(ana, ActorRef.noSender());
    }

    public void shutdown(){
        system.shutdown();
    }

}
