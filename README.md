# MQPlayground
A Simple RabbitMq with TLL and Dead Letter Queue

You can send an JMS event by triggering the endpoint. Queue has 1 minute TTL.

When you change the property of listener from application.properties as closed. Your message will go to dead letter then handled by dead letter queue listener.
If the listener was open, your message will be handled by it.

docker pull rabbitmq:3-management 
docker run -d --restart always --hostname localhost  --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
