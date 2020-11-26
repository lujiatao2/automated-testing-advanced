package com.lujiatao.c10;

import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;

public class MyParallelConfiguration implements ParallelExecutionConfiguration {

    private int parallelism;
    private int minimumRunnable;
    private int maxPoolSize;
    private int corePoolSize;
    private int keepAliveSeconds;

    public MyParallelConfiguration(int parallelism, int minimumRunnable, int maxPoolSize, int corePoolSize, int keepAliveSeconds) {
        this.parallelism = parallelism;
        this.minimumRunnable = minimumRunnable;
        this.maxPoolSize = maxPoolSize;
        this.corePoolSize = corePoolSize;
        this.keepAliveSeconds = keepAliveSeconds;
    }

    @Override
    public int getParallelism() {
        return parallelism;
    }

    @Override
    public int getMinimumRunnable() {
        return minimumRunnable;
    }

    @Override
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    @Override
    public int getCorePoolSize() {
        return corePoolSize;
    }

    @Override
    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

}
