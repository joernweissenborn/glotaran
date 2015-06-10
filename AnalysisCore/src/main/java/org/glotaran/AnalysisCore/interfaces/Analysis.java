package org.glotaran.analysiscore.interfaces;

import java.util.concurrent.CompletableFuture;

/**
 * Created by joern on 6/10/2015.
 */
public abstract class Analysis {

    public final CompletableFuture Finished = new CompletableFuture();

    public abstract Object Analyse();

}
