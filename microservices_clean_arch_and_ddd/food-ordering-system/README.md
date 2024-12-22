This project is based in the course Microservices: Clean Architecture, DDD, SAGA, Outbox & Kafka

## Visualize dependencies:

https://github.com/ferstl/depgraph-maven-plugin

    mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"


## How to run kafka on docker

1. Open the folder infrastructure/docker-compose.
2. Run the command `docker-compose -f common.yml -f zookeeper.yml up`
3. To check if ruok is running open a new terminal windows and run the command `echo ruok | nc localhost 2181`
4. To run kafka cluster run the command `docker-compose -f common.yml -f kafka_cluster.yml up`
5. Initialize kafka topics `docker-compose -f common.yml -f init_kafka.yml up`

We can confirm this by opening the [kafka manager UI](http://localhost:9000/). There will be necessary to add the cluster to do that will need to fill the fields with:
 - Cluster Name: food-ordering-system-cluster
 - Cluster Zookeeper Hosts: zookeeper:2181

After saving the changes we'll see the 3 Brokers and the topics that were created.