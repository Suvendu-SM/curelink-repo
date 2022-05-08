# curelink-newsletter system

### Newsletter system

 <h4>The implementaion of below system is available in this repo</h4>
   The whole system is built using spring boot framework to achieve microservice architecture.
  <p></p>
  <h4>How it works 👇</h4>
  <h5>About Eureka server</h5>
     Here each microservice has registered itself on the Eureka server.
     Eureka Server maintains a registry where it stores the IP address of each microservice.
     Each microservice sends its heartbeat to Eureka Server at a time interval, if it fails will remove the particular instance from 
     its registry.
  <p></p>
  <h5>About Microservice</h5>
  subscribe microservice : Subsribe microservice will handle request for user subscribing to persist in the Datatbase. Multiple microservice runs on a  different          port.
   <p></p>
  content microservice : Content microservice will handle requests for topic content creation to persist in the Database. Multiple microservice runs on a different         port.
   <p></p>
  consumer microservice : Consumer microservice will communicate with other microservice. Every incoming request comes to this microservice where it will call           request specific microservice.
    <p></p>    
   <img src ="https://github.com/Suvendu-SM/curelink-repo/blob/main/media/curelink%20newsletter.png" width="800px">
  <p></p>
    cons : The above system may not available every time as there is a single point of failure in case the server goes down.

### Improved system

<img src ="https://github.com/Suvendu-SM/curelink-repo/blob/main/media/improve%20curelink.png" width="800px">
