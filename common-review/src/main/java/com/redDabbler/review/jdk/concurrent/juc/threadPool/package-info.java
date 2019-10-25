package com.redDabbler.review.jdk.concurrent.juc.threadPool;
/**
 * Executor
 * ExecutorService
 *
 * Executors
 * ThreadPoolExecutor
 *
 * Callable Future RunnableFuture FutureTask
 *
 *
 * workers
 *
 *  workers是HashSet<Work>类型，即它是一个Worker集合。而一个Worker对应一个线程，也就是说线程池通过workers包含了"一个线程集合"。当Worker对应的线程池启动时，它会执行线程池中的任务；
 *  当执行完一个任务后，它会从线程池的阻塞队列中取出一个阻塞的任务来继续运行。
 *     wokers的作用是，线程池通过它实现了"允许多个线程同时运行"。
 *
 *
 *  workQueue
 *     workQueue是BlockingQueue类型，即它是一个阻塞队列。当线程池中的线程数超过它的容量的时候，线程会进入阻塞队列进行阻塞等待。
 *     通过workQueue，线程池实现了阻塞功能。
 *
 *
 *
 *线程池按以下行为执行任务
 *     1. 当线程数小于核心线程数时，创建线程。
 *     2. 当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
 *     3. 当线程数大于等于核心线程数，且任务队列已满
 *         - 若线程数小于最大线程数，创建线程
 *         - 若线程数等于最大线程数，根据拒绝策略拒绝任务
 *
 *
 *  如果设置的 corePoolSize 和 maximumPoolSize 相同，则创建了固定大小的线程池。
 *  如果将 maximumPoolSize 设置为基本的无界值（如 Integer.MAX_VALUE），则允许池适应任意数量的并发任务。
 *  在大多数情况下，核心池大小和最大池大小的值是在创建线程池设置的；但是，也可以使用 setCorePoolSize(int) 和 setMaximumPoolSize(int) 进行动态更改。
 *
 *
 *  poolSize是当前线程池的实际大小，即线程池中任务的数量。
 */