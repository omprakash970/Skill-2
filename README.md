# Hibernate CRUD Product Management System

A Spring Boot application demonstrating CRUD (Create, Read, Update, Delete) operations using Hibernate/JPA with MySQL database. This project manages Product entities with features to add, retrieve, update, and delete products.

## 📋 Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Database Configuration](#database-configuration)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [Usage Examples](#usage-examples)
- [API Operations](#api-operations)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- **Create**: Add single or multiple products to the database
- **Read**: Retrieve product information by ID
- **Update**: Modify product price and quantity
- **Delete**: Remove products from the database
- **Auto Schema Management**: Automatic table creation using Hibernate DDL
- **SQL Logging**: View formatted SQL queries in console

## 🛠 Technologies Used

- **Java 17**: Core programming language
- **Spring Boot 3.2.5**: Application framework
- **Spring Data JPA**: Data access layer
- **Hibernate**: ORM (Object-Relational Mapping) framework
- **MySQL**: Relational database
- **Maven**: Build and dependency management

## 📦 Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 17** or higher
- **Maven 3.6+** (or use the included Maven Wrapper)
- **MySQL Server 8.0+**
- **Git** (for cloning the repository)

## 📁 Project Structure

```
Skill-2/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── klu/
│   │   │           └── hibernate/
│   │   │               ├── Entity/
│   │   │               │   └── Product.java          # Product entity class
│   │   │               ├── Repository/
│   │   │               │   └── ProductRepository.java # JPA repository interface
│   │   │               ├── Service/
│   │   │               │   └── ProductService.java   # Business logic layer
│   │   │               └── HibernateApplication.java # Main application class
│   │   └── resources/
│   │       └── application.properties                # Application configuration
│   └── test/
│       └── java/                                     # Test classes
├── pom.xml                                           # Maven configuration
└── README.md                                         # Project documentation
```

## 🗄 Database Configuration

### Step 1: Create MySQL Database

Connect to your MySQL server and create a database:

```sql
CREATE DATABASE hibernate_db;
```

### Step 2: Configure Database Connection

Update the `src/main/resources/application.properties` file with your MySQL credentials:

```properties
spring.application.name=Hibernate
spring.datasource.url=jdbc:mysql://localhost:3306/hibernate_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD_HERE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

**Configuration Options:**

- `spring.datasource.url`: Database connection URL
- `spring.datasource.username`: MySQL username
- `spring.datasource.password`: MySQL password (⚠️ **Change this to your password**)
- `spring.jpa.hibernate.ddl-auto`: Hibernate DDL mode (update/create/create-drop/validate)
- `spring.jpa.show-sql`: Display SQL queries in console
- `spring.jpa.properties.hibernate.format_sql`: Format SQL queries for readability

> **⚠️ Security Warning:** Never commit real passwords to version control! Consider using:
> - Environment variables: `${DB_PASSWORD}`
> - Spring profiles for different environments
> - External configuration files excluded from Git
> - Secret management tools for production

## 🚀 Installation & Setup

### Option 1: Using Maven Wrapper (Recommended)

```bash
# Clone the repository
git clone https://github.com/omprakash970/Skill-2.git
cd Skill-2

# Make the Maven wrapper executable (Linux/Mac)
chmod +x mvnw

# Build the project
./mvnw clean install

# Skip tests if needed
./mvnw clean install -DskipTests
```

### Option 2: Using System Maven

```bash
# Clone the repository
git clone https://github.com/omprakash970/Skill-2.git
cd Skill-2

# Build the project
mvn clean install

# Skip tests if needed
mvn clean install -DskipTests
```

## ▶️ Running the Application

### Using Maven Wrapper

```bash
./mvnw spring-boot:run
```

### Using System Maven

```bash
mvn spring-boot:run
```

### Using Java

```bash
# After building, run the generated JAR
java -jar target/HibernateCRUDProduct-1.0.jar
```

## 💻 Usage Examples

The application runs as a CommandLineRunner and executes the following operations automatically on startup:

### 1. Insert Multiple Products

```java
service.addMultipleProducts(List.of(
    new Product("Laptop", "Gaming laptop", 75000, 5),
    new Product("Mouse", "Wireless mouse", 1200, 30),
    new Product("Keyboard", "Mechanical keyboard", 3500, 15)
));
```

**Console Output:** `✅ Inserted multiple products`

### 2. Retrieve Product by ID

```java
Product p = service.getProductById(1L);
System.out.println("📌 Retrieved: " + p);
```

**Example Output:** 
```
📌 Retrieved: Product [id=1, name=Laptop, description=Gaming laptop, price=75000.0, quantity=5]
```

### 3. Update Product Price

```java
Product updatedPrice = service.updatePrice(1L, 72000);
System.out.println("💰 Price Updated: " + updatedPrice);
```

**Example Output:**
```
💰 Price Updated: Product [id=1, name=Laptop, description=Gaming laptop, price=72000.0, quantity=5]
```

### 4. Update Product Quantity

```java
Product updatedQty = service.updateQuantity(2L, 50);
System.out.println("📦 Quantity Updated: " + updatedQty);
```

**Example Output:**
```
📦 Quantity Updated: Product [id=2, name=Mouse, description=Wireless mouse, price=1200.0, quantity=50]
```

### 5. Delete Product by ID

```java
service.deleteProduct(3L);
System.out.println("🗑️ Deleted product with id 3");
```

**Console Output:** `🗑️ Deleted product with id 3`

## 🔧 API Operations

### ProductService Methods

| Method | Description | Parameters | Return Type |
|--------|-------------|------------|-------------|
| `addMultipleProducts()` | Insert multiple products | `List<Product>` | `void` |
| `getProductById()` | Retrieve product by ID | `Long id` | `Product` |
| `updatePrice()` | Update product price | `Long id, double newPrice` | `Product` |
| `updateQuantity()` | Update product quantity | `Long id, int newQty` | `Product` |
| `deleteProduct()` | Delete product by ID | `Long id` | `void` |

### Product Entity Fields

| Field | Type | Description |
|-------|------|-------------|
| `id` | Long | Primary key (auto-generated) |
| `name` | String | Product name |
| `description` | String | Product description |
| `price` | double | Product price |
| `quantity` | int | Available quantity |

## 🧪 Testing

Run the tests using:

```bash
# Using Maven Wrapper
./mvnw test

# Using System Maven
mvn test
```

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Verify MySQL is running: `sudo systemctl status mysql`
   - Check database credentials in `application.properties`
   - Ensure `hibernate_db` database exists

2. **Port Already in Use**
   - Change the port in `application.properties`:
     ```properties
     server.port=8081
     ```

3. **Build Failures**
   - Clean Maven cache: `./mvnw clean`
   - Update dependencies: `./mvnw dependency:resolve`

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 📧 Contact

- **Author**: Omprakash
- **Repository**: [omprakash970/Skill-2](https://github.com/omprakash970/Skill-2)
- **Issues**: [Report bugs or request features](https://github.com/omprakash970/Skill-2/issues)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Hibernate team for the ORM implementation
- MySQL team for the database system

---

⭐ If you find this project helpful, please consider giving it a star on GitHub!
