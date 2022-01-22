package org.hunting.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx {

    //https://nirajsonawane.github.io/2019/01/27/Write-Clean-asynchronous-code-with-CompletableFuture-Java-8/

    //note
    //You might be wondering, Which Thread is executing the supplyAsync & runAsync task
    // and Who is creating these Threads? Similar to parallel streams CompletableFuture executes
    // these tasks in a thread obtained from the global ForkJoinPool.commonPool().

    public static void main(String[] args) {

        CompletableFutureEx completableFutureEx=new CompletableFutureEx();

        completableFutureEx.runAsyncEx_ForkJoinPool();
        completableFutureEx. supplyAsync_ForkJoinPool();

        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
        completableFutureEx. runAsyncEx_ExecutorService(newFixedThreadPool);
        completableFutureEx.supplyAsync__ExecutorService(newFixedThreadPool);

        completableFutureEx.thenAccept(completableFutureEx);
        completableFutureEx.thenRun(completableFutureEx);
        completableFutureEx.thenApply(completableFutureEx);

    }

    public  void runAsyncEx_ForkJoinPool() {

//        If We want to run some task in background that does not returns any value,
//        then we can use CompletableFuture.runAsync()
//        it takes a Runnable and returns CompletableFuture<Void>

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            processRunAsync();
        });

    }
    public void supplyAsync_ForkJoinPool(){

//        If we want to run some task in background that Returns Some Value,
//        then we can use CompletableFuture.supplyAsync() it takes a Supplier<T>
//        and returns completableFuture<T>
        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->processSupplyAsync());
        try {
         String str=   completableFuture.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public void runAsyncEx_ExecutorService(ExecutorService newFixedThreadPool) {

//        If We want to run some task in background that does not returns any value,
//        then we can use CompletableFuture.runAsync()
//        it takes a Runnable and returns CompletableFuture<Void>

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            processRunAsync();
        },newFixedThreadPool);

    }
    public void supplyAsync__ExecutorService(ExecutorService newFixedThreadPool){

//        If we want to run some task in background that Returns Some Value,
//        then we can use CompletableFuture.supplyAsync() it takes a Supplier<T>
//        and returns completableFuture<T>
        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->processSupplyAsync(),newFixedThreadPool);
        try {
            String str=   completableFuture.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //important notes

//    CompletableFuture Callbacks and Chaining
//    We know that CompletableFuture.get() is blocking and we want to avoid this. We should get some notification after Future completes.
//    CompletableFuture provides thenApply(), thenAccept() and thenRun() to attach callbacks
//
//    thenAccept()
//    If We want to run some code after receiving some value from Future then we can use thenAccept()
//    thenApply()
//    If We want to run some code after receiving value from Future and then want to return some value for this we can use thenAccept()
//    thenRun()
//    If We want to run some code after completion of the Future and dont want to return any value for this we can use thenRun()

    public void thenAccept(CompletableFutureEx obj){
        CompletableFuture.supplyAsync(obj::processThenAccept).thenAccept(obj::thenAcceptNotify).join();
    }
    public void thenRun(CompletableFutureEx completableFutureEx){
        CompletableFuture.runAsync(()->processRunAsync()).thenRun(this::thenRunNofity);
    }
    public void thenApply(CompletableFutureEx completableFutureEx){
       CompletableFuture<String> cf= CompletableFuture.supplyAsync(this::processSupplyAsyn1c).thenApply(this::thenApplyNotify);
        try {
            System.out.println("cffffffffffffffff "+cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    public void processRunAsync() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("example programm for run async");
    }
    public String processSupplyAsync(){
        System.out.println(Thread.currentThread().getName());
        return "supply async";
    }
    public String processThenAccept(){
        return "hey process then accept";
    }
    public void thenAcceptNotify(String str){
        System.out.println("then accept notify method calling");
    }
    public void thenRunNofity(){
        System.out.println("then run notify method calling notify ");
    }
    public String thenApplyNotify(String str){
        return "then apply notify method triggering";
    }

    public String processSupplyAsyn1c(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("supply async*************");
        return "supply async*************";
    }
}
