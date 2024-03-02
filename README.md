<h1>Description of My Project</h1>
Technologies:

- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- ReactJS

Tools:

- Postman
- MySQL Workbench 8.0
- IntelliJ

The frontend portion developed with ReactJS is accessible through the following link: https://github.com/PhanVanVien/amanoi-frontend.
<h1>Database Design</h1>
Now, let's break down the project into smaller, incremental steps. There are four models: User, Role, BookedRoom, and Room.

- The User model stores information such as name, email, etc.
- The Role model stores information about roles, including their names.
- The BookedRoom model stores reservation details like check-in date, check-out date, and associated room information, etc.
- The Room model stores information about rooms, including their name, type, price, etc.

There are relationships between these four models:

Many-to-Many Relationship:

- One User can have Many Roles, and conversely, One Role can have Many Users.

One-to-Many and Many-to-One Relationships:

- One User can have Many BookedRooms, and One BookedRoom can only belong to One User.
- One Room can have Many BookedRooms, and One BookedRoom can only belong to One Room.

<p align="center">
  <img src="https://github.com/PhanVanVien/amanoi-backend/assets/84467489/7a4808d4-165b-49e7-868a-11e85768c293" width="500"></img>
</p>
<hr/>
<h1>Spring Boot Flow</h1>
<p align="center">
<img src="https://github.com/PhanVanVien/amanoi-backend/assets/84467489/77f36fdd-f97c-4c7a-a813-701b8b3fe04c" width="500"> </img>
</p>

For beginners, I initially found this project confusing, particularly in terms of why repositories, services, and controllers are necessary. 
My understanding solidified as I delved into the workflow of Spring Boot.

- Controller: Manages HttpRequests, calls services when needed.
- Service: Contains business logic, handles aspects like resource access and response generation.
- Repository: Executes direct queries to the database.

By maintaining this workflow, you can easily discern the purpose of each segment of code, allowing you to understand the specific function it serves.

Reference: https://www.javatpoint.com/spring-boot-architecture
<hr/>
<h1>JWT</h1>
<p align="center">
  <img src="https://github.com/PhanVanVien/amanoi-backend/assets/84467489/05636df4-a380-48f4-87af-f549d28afa76" width="500"> </img>
</p>

- JWT consists of 3 parts: the header (algorithm, token type), the payload (data), and the verified signature.
- Encrypting and decrypting JWT between the client and server helps protect data transmitted over the network and ensures its integrity.
- For example: I use my credentials sent to the client side. Then, if the credentials are valid, the client side will encode my information into an encoded JWT. Now, I can use this encoded JWT for authentication and authorization on the server side.

Reference: https://jwt.io/introduction
<hr/>
<h1>JWT Workflow</h1>
<p align="center">
  <img src="https://github.com/PhanVanVien/amanoi-backend/assets/84467489/c3cafbb1-79fe-4bd1-9882-1976bf27a9d9" width="450"></img>
</p>

Basic JWT workflow can following present:

- User sends credentials (username, password) to Authentication Server.
- Server validates credentials and issues a JWT if valid.
- User includes JWT in requests to Resource Server.
- Resource Server decodes JWT and verifies its integrity.
- Resource Server checks permissions embedded in the JWT.
- Resource Server grants or denies access to the requested resource based on permissions.

Reference: https://stackoverflow.com/questions/65351531/what-is-the-flow-of-using-jwt-work-on-the-frontend
<hr/>
<h1>Architecture</h1>
<p align="center">
  <img src="https://www.bezkoder.com/wp-content/uploads/spring-boot-authentication-spring-security-architecture.png"></img>
</p>
