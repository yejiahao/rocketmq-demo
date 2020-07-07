### 参考[**文章**](https://juejin.im/post/5ea159e4f265da47f0794da5)演练

### 压测记录
```sh
[root@vm2 ~]# ab -n 1000 -c 20 http://vm0.yejh.cn:9988/praise
This is ApacheBench, Version 2.3 <$Revision: 655654 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking vm0.yejh.cn (be patient)
Completed 100 requests
Completed 200 requests
Completed 300 requests
Completed 400 requests
Completed 500 requests
Completed 600 requests
Completed 700 requests
Completed 800 requests
Completed 900 requests
Completed 1000 requests
Finished 1000 requests


Server Software:        
Server Hostname:        vm0.yejh.cn
Server Port:            9988

Document Path:          /praise
Document Length:        3 bytes

Concurrency Level:      20
Time taken for tests:   2.650 seconds
Complete requests:      1000
Failed requests:        110
   (Connect: 0, Receive: 0, Length: 110, Exceptions: 0)
Write errors:           0
Total transferred:      122964 bytes
HTML transferred:       3131 bytes
Requests per second:    377.33 [#/sec] (mean)
Time per request:       53.004 [ms] (mean)
Time per request:       2.650 [ms] (mean, across all concurrent requests)
Transfer rate:          45.31 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    5   4.3      5      45
Processing:     3   15  53.3     11    1677
Waiting:        0   11  53.0      8    1672
Total:          5   21  53.3     17    1678

Percentage of the requests served within a certain time (ms)
  50%     17
  66%     20
  75%     22
  80%     24
  90%     30
  95%     41
  98%     56
  99%     58
 100%   1678 (longest request)
```

***info.log***
```
[INFO ] [2020-07-08 00:19:44.046] [ConsumeMessageThread_1] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [101]
[INFO ] [2020-07-08 00:19:44.080] [ConsumeMessageThread_2] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [103]
[INFO ] [2020-07-08 00:19:44.090] [ConsumeMessageThread_3] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [106]
[INFO ] [2020-07-08 00:19:44.091] [ConsumeMessageThread_4] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [109]
[INFO ] [2020-07-08 00:19:44.091] [ConsumeMessageThread_5] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [108]
[INFO ] [2020-07-08 00:19:47.038] [ConsumeMessageThread_8] c.y.r.r.l.PraiseListener.onMessage[25] | Message: [107]
...
```