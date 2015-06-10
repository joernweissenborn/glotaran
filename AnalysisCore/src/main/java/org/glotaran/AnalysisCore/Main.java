package org.glotaran.analysiscore;

import org.glotaran.analysiscore.mock.Analysis;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        AnalysisInterface ai = new AnalysisInterface(1);
        org.glotaran.analysiscore.interfaces.Analysis ana = new Analysis();
        ai.doAnalysis(ana);
        try {
            System.out.println(ana.Finished.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ai.shutdown();

    }





}
