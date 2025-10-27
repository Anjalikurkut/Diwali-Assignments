<<<<<<< HEAD
# E-Commerce REST API (Spring Boot)

## What you get
- Simple Spring Boot project (H2 in-memory DB) with endpoints for:
  - Customer CRUD and register (passwords hashed with BCrypt)
  - Product CRUD and search
  - Order placement, view, list by customer, status update, cancel

## How to run
1. Install Java 11+ and Maven.
2. From project root run:
   mvn spring-boot:run
3. App runs on http://localhost:8080
4. H2 console: http://localhost:8080/h2-console (jdbc url: jdbc:h2:mem:ecomdb, user sa)

## Endpoints (examples)
- POST /api/customers/register
- GET /api/customers
- POST /api/products
- GET /api/products
- POST /api/orders

=======
# Student Management System (Day 07) - ASP.NET Core MVC

## What is included
- ASP.NET Core MVC project targeting .NET 6
- Entity Framework Core configured for SQL Server (use LocalDB by default)
- Models: `Student`, `Course`
- CRUD controllers + Razor views for Students and Courses
- Data annotations for validation

## Notes on Database First vs Code First
Your instruction said *Database First*. The project here is provided as a **Code First**-style source for ease of testing. If you must use Database First (scaffold models from an existing database), you can run the following command after creating the database and then scaffold:
```
dotnet ef dbcontext scaffold "Your_Connection_String" Microsoft.EntityFrameworkCore.SqlServer -o Models -c ApplicationDbContext
```

## How to run
1. Install .NET 6 SDK.
2. From project folder run:
```
dotnet restore
dotnet ef database update   # optional if you add migrations
dotnet run
```
3. Open `https://localhost:5001` or `http://localhost:5000` (app uses default Kestrel URLs).

## To use SQL Server LocalDB (default connection string in appsettings.json)
No changes required; LocalDB will create the DB file automatically on first run.
>>>>>>> bc0c936193a55c7cf57b88d9327c447f49fc03ce
