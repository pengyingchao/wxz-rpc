//package com.github.wxz.rpc.netty.jmx;
//
//import java.other.List;
//import java.other.concurrent.CountDownLatch;
//
///**
// * @author xianzhi.wang
// * @date 2017/12/20 -21:11
// */
//public class MetricsAggregationTask implements Runnable {
//    private boolean flag = false;
//    private MetricsTask[] tasks;
//    private List<ModuleMetricsVisitor> visitors;
//    private CountDownLatch latch;
//
//    public MetricsAggregationTask(boolean flag, MetricsTask[] tasks, List<ModuleMetricsVisitor> visitors, CountDownLatch latch) {
//        this.flag = flag;
//        this.tasks = tasks;
//        this.visitors = visitors;
//        this.latch = latch;
//    }
//
//    @Override
//    public void run() {
//        if (flag) {
//            try {
//                for (MetricsTask task : tasks) {
//                    //System.out.println(task.getResult().get(0));
//                    visitors.add(task.getResult().get(0));
//                }
//            } finally {
//                latch.countDown();
//            }
//        } else {
//            flag = true;
//        }
//    }
//}
//
