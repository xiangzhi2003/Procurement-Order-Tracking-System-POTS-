# Procurement Order Tracking System (POTS)

A comprehensive Java Swing-based Enterprise Resource Planning (ERP) system designed for inventory and supply chain management with role-based access control.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [System Requirements](#system-requirements)
- [Installation](#installation)
- [Usage](#usage)
- [User Roles](#user-roles)
- [Project Structure](#project-structure)
- [Data Files](#data-files)
- [Sample Login Credentials](#sample-login-credentials)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Procurement Order Tracking System (POTS) is a desktop application built with Java Swing that manages inventory, purchases, sales, and financial operations for businesses. It implements a complete supply chain workflow from sales requisitions through purchase orders to payment processing.

**Key Stats:**
- **Lines of Code**: ~7,190
- **Total Files**: 68
- **User Roles**: 5
- **Main Features**: 20+

## Features

### Core Functionality

- **User Authentication & Authorization**: Secure login system with role-based access control
- **Inventory Management**: Real-time stock tracking with automatic understock detection
- **Purchase Management**: Complete purchase order workflow from requisition to approval
- **Sales Management**: Sales entry, item management, and daily sales tracking
- **Financial Management**: Payment processing, supplier payment tracking, and PO verification
- **Supplier Management**: Comprehensive supplier database with payment terms

### Role-Specific Features

#### Administrator
- User account management (create, edit, delete)
- Access to all manager functions
- System-wide oversight

#### Sales Manager
- Create and manage sales items
- Record daily sales entries
- Monitor stock levels
- Generate purchase requisitions for low stock items

#### Purchase Manager
- View and manage suppliers
- Generate purchase orders from requisitions
- Track supplier payment schedules
- Manage inventory items for purchasing

#### Inventory Manager
- View detailed inventory data
- Modify stock levels and prices
- Update item information
- Monitor stock status (Understock/Sufficient)
- Access supplier information

#### Finance Manager
- View stock status from financial perspective
- Track supplier payment obligations
- Verify and approve purchase orders
- Process supplier payments
- Maintain payment history

## Technology Stack

| Component | Technology |
|-----------|-----------|
| Language | Java |
| GUI Framework | Swing (JFrame, JPanel, JTable, etc.) |
| Build Tool | Apache Ant |
| IDE | NetBeans |
| Data Storage | File System (Text Files - CSV format) |
| Architecture | MVC-like Pattern |
| Design Patterns | CRUD Operations, Interface Implementation |

## System Requirements

- **Java Development Kit (JDK)**: Version 8 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: Minimum 512 MB RAM
- **Disk Space**: Minimum 50 MB free space
- **IDE** (optional): NetBeans (recommended) or any Java-compatible IDE

## Installation

### Option 1: Using NetBeans (Recommended)

1. Clone the repository:
   ```bash
   git clone https://github.com/xiangzhi2003/Procurement-Order-Tracking-System-POTS-.git
   cd Procurement-Order-Tracking-System-POTS-
   ```

2. Open NetBeans IDE

3. Click **File → Open Project**

4. Navigate to the cloned directory and select the project

5. Right-click the project and select **Build**

6. Run the project by clicking the **Run** button or pressing `F6`

### Option 2: Using Command Line (Ant)

1. Clone the repository:
   ```bash
   git clone https://github.com/xiangzhi2003/Procurement-Order-Tracking-System-POTS-.git
   cd Procurement-Order-Tracking-System-POTS-
   ```

2. Build the project:
   ```bash
   ant compile
   ```

3. Run the application:
   ```bash
   ant run
   ```

### Option 3: Manual Compilation

1. Clone the repository

2. Navigate to the project directory

3. Compile all Java files:
   ```bash
   javac -d bin src/oodj_assignment/*.java src/oodj_assignment_functions/*.java
   ```

4. Run the application:
   ```bash
   java -cp bin oodj_assignment.LoginForm
   ```

## Usage

### Starting the Application

1. Launch the application using one of the installation methods above
2. The **Login Form** will appear
3. Enter your username and password
4. Click **Login** to access your role-specific dashboard

### Workflow Example

**Scenario: Low Stock Item Replenishment**

1. **Sales Manager** notices low stock while viewing Stock Level
2. **Sales Manager** creates a Purchase Requisition
3. **Purchase Manager** reviews requisition and generates Purchase Order
4. **Finance Manager** verifies and approves the Purchase Order
5. **Finance Manager** processes payment to supplier
6. **Inventory Manager** updates stock levels upon receipt of goods

## User Roles

### Administrator
- **Dashboard**: [AM_MainForm.java](src/oodj_assignment/AM_MainForm.java)
- **Capabilities**: Full system access, user management

### Sales Manager
- **Dashboard**: [SM_MainPage.java](src/oodj_assignment/SM_MainPage.java)
- **Capabilities**: Sales operations, stock monitoring, requisition creation

### Purchase Manager
- **Dashboard**: [PM_MainForm.java](src/oodj_assignment/PM_MainForm.java)
- **Capabilities**: Purchase orders, supplier management

### Inventory Manager
- **Dashboard**: [IM_MainForm.java](src/oodj_assignment/IM_MainForm.java)
- **Capabilities**: Stock management, inventory updates

### Finance Manager
- **Dashboard**: [FM_MainForm.java](src/oodj_assignment/FM_MainForm.java)
- **Capabilities**: Payment processing, PO verification

## Project Structure

```
OODJ_Assignment-master/
├── src/
│   ├── oodj_assignment/                    # UI Layer (Swing Forms)
│   │   ├── LoginForm.java                  # Application entry point
│   │   ├── AM_MainForm.java                # Administrator dashboard
│   │   ├── PM_MainForm.java                # Purchase Manager dashboard
│   │   ├── PM_PurchaseOrder.java           # Purchase Order form
│   │   ├── SM_MainPage.java                # Sales Manager dashboard
│   │   ├── SM_SalesEntryForm.java          # Sales entry form
│   │   ├── SM_SalesItemForm.java           # Sales item management
│   │   ├── SM_StockLevelFrame.java         # Stock monitoring
│   │   ├── SM_PurchaseRequisitionForm.java # Requisition form
│   │   ├── IM_MainForm.java                # Inventory Manager dashboard
│   │   ├── IM_ModifyStock.java             # Stock modification
│   │   ├── FM_MainForm.java                # Finance Manager dashboard
│   │   ├── FM_MakePayment.java             # Payment processing
│   │   └── ... (other UI components)
│   │
│   ├── oodj_assignment_functions/         # Business Logic Layer
│   │   ├── CRUD.java                       # File I/O operations
│   │   ├── Administrator.java              # User authentication & management
│   │   ├── Inventory.java                  # Inventory operations
│   │   ├── Finance.java                    # Financial operations
│   │   ├── PurchaseManager.java            # Purchase operations
│   │   ├── SalesEntry.java                 # Sales data model
│   │   ├── SalesItem.java                  # Sales item model
│   │   ├── StockLevel.java                 # Stock monitoring
│   │   ├── PRGenerator.java                # Purchase requisition generation
│   │   └── IDGenerator.java                # ID generation interface
│   │
│   ├── oodj_assignment_data/              # Data Files (CSV-like format)
│   │   ├── Accounts.txt                    # User credentials
│   │   ├── InventoryData.txt               # Inventory items
│   │   ├── InventorySupplier.txt           # Supplier information
│   │   ├── PurchaseOrder.txt               # Purchase orders
│   │   ├── PurchaseRequisition.txt         # Requisitions
│   │   ├── SalesEntry1.txt                 # Sales transactions
│   │   ├── SalesItem.txt                   # Sales items
│   │   ├── PaymentHistory.txt              # Payment records
│   │   ├── DailySalesEntry.txt             # Daily sales logs
│   │   └── MonthlySalesReport.txt          # Sales reports
│   │
│   └── oodj_assignment_images/            # UI Icons/Images
│       └── logout.png
│
├── nbproject/                              # NetBeans project files
├── build.xml                               # Ant build configuration
├── manifest.mf                             # JAR manifest
└── README.md                               # This file
```

## Data Files

### Accounts.txt
Stores user credentials and roles.

**Format:**
```
UID,Username,Password,Role
U001,sten,sten123,Administrator
```

### InventoryData.txt
Contains inventory item information.

**Format:**
```
itemCode,itemName,category,itemPrice,stock,minStockAllowed,stockUpdateDate,stockStatus,quantityReq,supplierID,supplierName
I001,Hair Dryer,Home Appliances,399.11,8,10,5/10/2024,Understock,2,S001,Electro Supply
```

### InventorySupplier.txt
Supplier database with payment information.

**Format:**
```
supplierID,supplierName,paymentMethod,paymentDue
S001,Electro Supply,Bank Transfer,2024-07-01
```

### PurchaseOrder.txt
Purchase order records.

**Format:**
```
orderID,requisitionID,supplierName,itemName,itemPrice,quantity,orderDate,status
PO001,PR01,Electro Supply,Hair Dryer,399.11,2,5/10/2024,Pending
```

## Sample Login Credentials

| Username | Password | Role |
|----------|----------|------|
| sten | sten123 | Administrator |
| gckho | gckho123 | Inventory Manager |
| david | david123 | Purchase Manager |
| cxz | cxz123 | Finance Manager |
| raidah | raidah123 | Sales Manager |

**Note**: These are sample credentials for testing purposes. In production, implement proper password hashing and security measures.

## Screenshots

### Login Screen
The application starts with a secure login form that authenticates users and directs them to their role-specific dashboard.

### Role Dashboards
Each user role has a customized dashboard with access to relevant features and operations.

### Inventory Management
Real-time stock tracking with automatic alerts for low stock items.

### Purchase Order Workflow
Complete purchase order lifecycle from requisition to payment.

## Design Patterns

### MVC-like Architecture
- **Model**: Data classes (SalesEntry, SalesItem, etc.)
- **View**: Swing UI forms (LoginForm, MainForms, etc.)
- **Controller**: Business logic classes (Administrator, Finance, Inventory, etc.)

### Interface Implementation
The `IDGenerator` interface is implemented by `Administrator` and `Inventory` classes for generating unique IDs across the system.

### CRUD Operations
Centralized file I/O through the `CRUD.java` class handles all Create, Read, and Update operations for data files.

## Key OOP Concepts Demonstrated

- **Encapsulation**: Private fields with public getters/setters
- **Inheritance**: Common functionality shared across manager classes
- **Polymorphism**: Interface implementation for ID generation
- **Abstraction**: Separation of UI, business logic, and data layers

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Enhancements

- [ ] Migrate from file-based storage to database (MySQL/PostgreSQL)
- [ ] Implement password hashing and encryption
- [ ] Add data export functionality (PDF, Excel)
- [ ] Implement email notifications for low stock
- [ ] Add reporting and analytics dashboard
- [ ] Implement barcode scanning for inventory
- [ ] Add multi-language support
- [ ] Create web-based version using Spring Boot

## License

This project is an academic assignment created for educational purposes.

## Contact

**Developer**: Xiang Zhi , and my groupmates
**GitHub**: [@xiangzhi2003](https://github.com/xiangzhi2003)
**Repository**: [Procurement Order Tracking System](https://github.com/xiangzhi2003/Procurement-Order-Tracking-System-POTS-)

---

**Developed with Java Swing | Built for Supply Chain Management**
