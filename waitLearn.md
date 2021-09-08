# wait learn
开发过程中存在问题，需要临时记录以保存现场，方便下次恢复；
格式： 日期 + 知识点 + 对应类路径
#线程池学习笔记
#线程池的优点
    线程池解决两个不同的问题：它们通常在执行大量异步任务时提供改进的性能，因为减少了每个任务的调用开销，
    并且它们提供了一种限制和管理资源的方法， 包括线程，在执行任务集合时消耗。
    每个线程池还维护一些基本的统计信息，例如已完成任务的数量。
#线程池线程创建机制
    当一个新任务在方法 {@link #execute(Runnable)} 中提交时，并且少于 corePoolSize 的线程正在运行，
    创建一个新线程来处理请求，即使其他工作线程空闲。如果运行的线程数超过 corePoolSize 但少于 maximumPoolSize 线程，
    则仅当队列已满时才会创建新线程。通过将 corePoolSize 和 maximumPoolSize设置为相同，您可以创建一个固定大小的线程池。
    通过将maximumPoolSize 设置为基本上无界的值，例如 {@code Integer.MAX_VALUE}，您允许池容纳任意数量的并发任务。
    最典型的是，核心池和最大池大小仅在构造时设置，但它们也可以使用 {@link #setCorePoolSize} 和 {@link #setMaximumPoolSize} 动态更改。 
#线程池的状态
    RUNNING 
        表示线程池处于运行状态，能够接受新提交的任务且能对已添加的任务进行处理。RUNNING状态是线程池的初始化状态，线程池一旦被创建就处于RUNNING状态。
    SHUTDOWN 
        线程处于关闭状态，不接受新任务，但可以处理已添加的任务。RUNNING状态的线程池调用shutdown后会进入SHUTDOWN状态。
    STOP 
        线程池处于停止状态，不接收任务，不处理已添加的任务，且会中断正在执行任务的线程。RUNNING状态的线程池调用了shutdownNow后会进入STOP状态。
    TIDYING (整理状态)
        当所有任务已终止，且任务数量为0时，线程池会进入TIDYING。当线程池处于SHUTDOWN状态时，阻塞队列中的任务被执行完了，且线程池中没有正在执行的任务了，状态会由SHUTDOWN变为TIDYING。当线程处于STOP状态时，线程池中没有正在执行的任务时则会由STOP变为TIDYING。
    TERMINATED （终止）
        线程终止状态。处于TIDYING状态的线程执行terminated()后进入TERMINATED状态。
#获取线程池的方式
    1、Executors 线程池工厂类 获取12种拥有指定特点的线程池
    2、ThreadPoolExecutor 线程池实例类 提供线程池实例化构造方法

    

