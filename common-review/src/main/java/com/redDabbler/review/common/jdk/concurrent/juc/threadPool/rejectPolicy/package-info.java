package com.redDabbler.review.common.jdk.concurrent.juc.threadPool.rejectPolicy;


/**
 * 线程池的拒绝策略，是指当任务添加到线程池中被拒绝，而采取的处理措施
 * 任务之所以被拒绝，通常有2种
 * 1.线程池异常关闭
 * 2.任务数量大于线程池的最大限制
 *
 * 拒绝策略有4种：默认是AbortPolicy
 * AbortPolicy：当被拒绝时，将抛出RejectExecutionException异常
 * CallerRunsPolicy 被拒绝时，会在线程池当前正在运行的Thread中处理被拒绝的任务
 * DiscardOldestPollicy 被拒绝时，线程池会放弃等待队列中最旧的处理任务，然后将被拒绝的任务添加到等待队列中。
 * DiscardPolicy 被拒绝时，线程池直接丢弃被拒绝的任务
 */