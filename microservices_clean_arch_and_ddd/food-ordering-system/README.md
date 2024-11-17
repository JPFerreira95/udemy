This project is based in the course Microservices: Clean Architecture, DDD, SAGA, Outbox & Kafka

## Visualize dependencies:

https://github.com/ferstl/depgraph-maven-plugin

    mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system*:*"


