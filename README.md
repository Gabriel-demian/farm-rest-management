# farm-rest-management
 
![0 (2)](https://user-images.githubusercontent.com/57782295/99152996-47f96f80-2684-11eb-9b39-844c60a01033.jpg)

# Front

https://github.com/Gabriel-demian/farm-react-web 

# TODO
- [x] Finalizar el Rest controller de las Granjas y sus respectivos services y repo. 
- [x] Finalizar el Rest controller de las Gallinas y sus respectivos services y repo.
- [x] Finalizar el Rest controller de los Huevos y sus respectivos services y repo.
- [x] Generar una tabla clave valor de tipo diccionario, (Reference) en ella tendrá los precios de venta y "tiempo de vida de un huevo y gallina"
- [x] Verificar que todos los métodos de los controllers funcionan correctamente. 
- [x] Se agrega Swagger para documentación ( http://localhost:8080/swagger/dist/index.html#/ )
- [x] Generar las clases DTO
- [x] Generar un servicio para la lógica de negocio para no sobrecargar el Controller. (LogicService y LogicServiceImpl)
     - [x] Generar la lógica de compra de huevos y gallinas
     - [x] Generar la lógica de venta de huevos y gallinas
- [x] Configurar los constraints a las tablas
- [ ] Agregar validadores a las clases Entidad
- [ ] Generar los casos de prueba
- [ ] Generar los casos de uso (formalmente, solo se encuentran comentados en "Algo de lógica de negocio")
- [x] Generar una tabla clave valor de tipo diccionario donde tendrá los id de las granjas y de los usuarios asignados
- [ ] Generar dos tablas, una de transacciones y la otra con los detalles de las transacciones
- [ ] Seguir actualizando la lista
- [ ] Agregar algo interesante acá

# Creacion de la base de datos y sus respectivas tablas (Se deja adjunto el archivo farm-management.sql)
<details>
  <summary>Click to expand!</summary>
 
 ```
   CREATE SCHEMA `farm-management` ;

   SET GLOBAL time_zone = '-3:00';
   
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: farm-management
-- ------------------------------------------------------
--
-- Table structure for table `chicken`
--

  DROP TABLE IF EXISTS `chicken`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!50503 SET character_set_client = utf8mb4 */;
  CREATE TABLE `chicken` (
    `chicken_id` int NOT NULL AUTO_INCREMENT,
    `farm_id` int NOT NULL,
    `birth_date` date DEFAULT NULL,
    `expiration_date` date DEFAULT NULL,
    PRIMARY KEY (`chicken_id`),
    KEY `farm_idx` (`farm_id`),
    CONSTRAINT `farm` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE
  ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  /*!40101 SET character_set_client = @saved_cs_client */;

  --
  -- Dumping data for table `chicken`
  --

  LOCK TABLES `chicken` WRITE;
  /*!40000 ALTER TABLE `chicken` DISABLE KEYS */;
  INSERT INTO `chicken` VALUES (1,1,'2020-11-22','2021-11-22'),(2,1,'2020-11-22','2020-11-22'),(3,1,'2020-11-22','2020-11-22'),(5,9,'2020-11-28','2020-11-28'),(6,9,'2020-11-28','2021-11-28'),(7,9,'2020-11-28','2021-11-28'),(8,9,'2020-11-28','2021-11-28'),(9,1,'2020-12-01','2020-12-01');
  /*!40000 ALTER TABLE `chicken` ENABLE KEYS */;
  UNLOCK TABLES;

  --
  -- Table structure for table `egg`
  --

  DROP TABLE IF EXISTS `egg`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!50503 SET character_set_client = utf8mb4 */;
  CREATE TABLE `egg` (
    `egg_id` int NOT NULL AUTO_INCREMENT,
    `farm_id` int NOT NULL,
    `birth_date` date DEFAULT NULL,
    `expiration_date` date DEFAULT NULL,
    PRIMARY KEY (`egg_id`),
    KEY `farm_id_idx` (`farm_id`),
    CONSTRAINT `farm_id` FOREIGN KEY (`farm_id`) REFERENCES `farm` (`farm_id`) ON DELETE CASCADE
  ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  /*!40101 SET character_set_client = @saved_cs_client */;

  --
  -- Dumping data for table `egg`
  --

  LOCK TABLES `egg` WRITE;
  /*!40000 ALTER TABLE `egg` DISABLE KEYS */;
  INSERT INTO `egg` VALUES (1,1,'2020-11-30','2020-11-30'),(3,1,'2020-11-29','2020-12-29'),(6,1,'2020-11-30','2020-12-30'),(10,9,'2020-11-28','2020-11-28'),(11,11,'2020-11-28','2020-11-28'),(12,11,'2020-11-28','2020-11-28'),(13,11,'2020-11-28','2020-11-28'),(14,11,'2020-12-01','2020-12-01');
  /*!40000 ALTER TABLE `egg` ENABLE KEYS */;
  UNLOCK TABLES;

  --
  -- Table structure for table `farm`
  --

  DROP TABLE IF EXISTS `farm`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!50503 SET character_set_client = utf8mb4 */;
  CREATE TABLE `farm` (
    `farm_id` int NOT NULL AUTO_INCREMENT,
    `farm_name` varchar(45) NOT NULL,
    `chicken_bought` int DEFAULT NULL,
    `chicken_sold` int DEFAULT NULL,
    `egg_bought` int DEFAULT NULL,
    `egg_sold` int DEFAULT NULL,
    `income` double DEFAULT NULL,
    `expenses` double DEFAULT NULL,
    PRIMARY KEY (`farm_id`),
    UNIQUE KEY `farm_id_UNIQUE` (`farm_id`),
    UNIQUE KEY `farm_name_UNIQUE` (`farm_name`)
  ) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  /*!40101 SET character_set_client = @saved_cs_client */;

  --
  -- Dumping data for table `farm`
  --

  LOCK TABLES `farm` WRITE;
  /*!40000 ALTER TABLE `farm` DISABLE KEYS */;
  INSERT INTO `farm` VALUES (1,'Test Updated Farm',10,110,0,5000,900,200),(9,'Farm November',10,3,20,0,440,110),(10,'Farm Empty',0,0,0,0,0,0),(11,'Only Eggs Farm',0,0,0,0,0,0);
  /*!40000 ALTER TABLE `farm` ENABLE KEYS */;
  UNLOCK TABLES;

  --
  -- Table structure for table `reference`
  --

  DROP TABLE IF EXISTS `reference`;
  /*!40101 SET @saved_cs_client     = @@character_set_client */;
  /*!50503 SET character_set_client = utf8mb4 */;
  CREATE TABLE `reference` (
    `key` varchar(45) NOT NULL,
    `value` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`key`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  /*!40101 SET character_set_client = @saved_cs_client */;

  --
  -- Dumping data for table `reference`
  --

  LOCK TABLES `reference` WRITE;
  /*!40000 ALTER TABLE `reference` DISABLE KEYS */;
  INSERT INTO `reference` VALUES ('chickenExpirationDate','365'),('chSalePrice','175'),('eggExpirationDate','21'),('eggSalePrice','50');
  /*!40000 ALTER TABLE `reference` ENABLE KEYS */;
  UNLOCK TABLES;



     
  ```
     
</details>

# Datos de una granja JSON

- Datos ejemplo para un update completo. URL: http://localhost:8080/api/farms/1 Method:PUT
<details>
  <summary>Click to expand!</summary>

```
{
  "id": 1,
  "farmName": "Test  Farm!",
  "chickenBought": 80,
  "chickenSold": 10,
  "eggBought": 0,
  "eggSold": 24,
  "income": 350,
  "expenses": 100,
  "eggs": [
    {
      "id": 1,
      "farm": null,
      "birthDate": "2020-11-30T00:00:00",
      "expirationDate": "2020-11-30T00:00:00"
    },
    {
      "id": 3,
      "farm": null,
      "birthDate": "2020-11-29T00:00:00",
      "expirationDate": "2020-12-29T00:00:00"
    },
    {
      "id": 6,
      "farm": null,
      "birthDate": "2020-11-30T00:00:00",
      "expirationDate": "2020-12-30T00:00:00"
    },
    {
      "id": 9,
      "farm": null,
      "birthDate": "2020-11-22T00:00:00",
      "expirationDate": "2020-11-22T00:00:00"
    }
  ],
  "chickens": [
    {
      "id": 1,
      "farm": null,
      "birthDate": "2020-11-22T00:00:00",
      "expirationDate": "2021-11-22T00:00:00"
    },
    {
      "id": 2,
      "farm": null,
      "birthDate": "2020-11-22T00:00:00",
      "expirationDate": "2020-11-22T00:00:00"
    },
    {
      "id": 3,
      "farm": null,
      "birthDate": "2020-11-22T00:00:00",
      "expirationDate": "2020-11-22T00:00:00"
    }
  ]
}
```

</details>

# Datos usados en Postman (urls, ejemplos de métodos que se pueden usar con la api)

```
https://documenter.getpostman.com/view/8263715/TVep9TrY
```

# Algo de lógica de negocio
<details>
  <summary>Click to expand!</summary>
 
```
 # Logica Compra/venta
 Ej: Gallinas
 La granja puede vender una gallina, la cual se debe seleccionar de una lista de gallinas disponibles. 
 Se deberá incremetar el valor de "incomes" en la granja y borrar de la tabla de gallinas los ID 
 de gallinas seleccionadas. 
 En caso de comprar se agregará el valor de compra a "expenses" y agregar las X gallinas con sus respectivos IDs
```
 
```
# Lógica Crecimiento
La gallina una vez pasados X días se considerará como fallecida y se eliminará de la tabla de gallinas. 
Se agregará el valor de venta de cada gallina a "expenses" para impactar el dinero perdido por la "no venta"

Los huevos una vez transcurridos los 21 días sin ser vendidos se deberá agregar a la tabla de gallinas 
y eliminar el ID del respectivo huevo.
```

```
# Usuarios
 Cada granja tendrá asignado un máximo de 2 usuarios. al realizar una transacción (compra o venta) desde la granja 
 el usuario que la realizó deberá quedar registrado en la tabla de Transaccion_details.

 Se tendrá la tabla farmUsers donde quedará registrado que farmId tiene asignado cada usuario.
 Los usuarios serán validados y almacenados en firebase.
 (falta crear definir la validación del backend contra firebase)
```
 
</details>

# Diagrama de la aplicación
<details>
 <summary>Click to expand!</summary>
 
![lógica](https://user-images.githubusercontent.com/57782295/99194573-f83ba680-275e-11eb-9434-7d65ec95d652.jpg)

![tenor](https://user-images.githubusercontent.com/57782295/99194585-0c7fa380-275f-11eb-8d6e-6d40d37d7bb6.gif)

 </details>
