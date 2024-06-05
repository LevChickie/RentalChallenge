# RentalChallenge
During the Programming Exercise, the developer got the freedom to choose any framework to work with. I chose Java Spring Boot for flexibility as a backend framework and Angular for structure as a frontend framework. I developed a MongoDB database with some starter data.

The following was my working plan.
The backend must be operable in order to validate if the database is available and process the incoming frontend queries. Java Spring Boot was an ideal solution because I have prior experience in it and it was not a problem to set up the controllers, repositories and models. I designed three model classes rather than the required two because a rental company must have some data on the previous rents and their information such as cost and duration. I created a Car, Client and Rental model. Since Java Spring Boot is great with the REST.API, it was a good choice for the backend.
The database for this project was not as simple choice as the Java Spring Boot and the REST.API. I thought making a MongoDB database and access it or create a local database for the task. In the end I decided to make a MongoDB database since it reflects the real working environment better. I used MongoDB because I had some prior experience with it and because it has a great community version. After making an example database I tested it using MongoShell to make sure that the database is available for API calls.

I had an annoying issue during the testing of the backend and the database. The issue was hard to solve because I received a Whitelabel Error and since it is a very general error message finding the reason for the error was quite a challenge. After a long debugging and researching process, I have found that the Java Spring structure has to follow a certain pattern in order to work and since I built up my application from scratch there was an issue with the package naming conventions.

The frontend was a difficult choice to make. I was thinking about working in React framework or Angular framework. In the end, I chose Angular over React because even though it is more complex framework I could complete my plan easier. The plan was to make generic components that could be used for all data types and thus minimalizing the required components or pages. Some parts of the program, like the listing of all elements, regardless of the data type could be moved in one single component. I made a generic class for the data types that includes the common traits such as identifier, and a generic service that will run the http calls regardless of the values sent and received from frontend. I believe even though it increased the code complexity, it reduced the code base size and made the web application more scalable because these generic components could be used later for other additional data types that might be introduced in the database, making the further development much simpler and faster.

In Angular I used to list all objects an Grid component that includes a Card for each collection entry. The representation of the Card could not be generic because the properties of the database entries unavailable in generic components. Therefore, I had to make a card-view for all data types, but it was only representing the data itself and providing an opportunity to edit the current value. Even though deleting an entry would be a great generic option, editing an entry and creating a new one requires the concrete data type. To make the representation more coherent, I moved the delete logic as well in the card-view.
