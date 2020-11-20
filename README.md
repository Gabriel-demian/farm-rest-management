# farm-rest-management
 
![0 (2)](https://user-images.githubusercontent.com/57782295/99152996-47f96f80-2684-11eb-9b39-844c60a01033.jpg)

# TODO
- [x] Finalizar el Rest controller de las Granjas y sus respectivos services y repo. 
- [x] Finalizar el Rest controller de las Gallinas y sus respectivos services y repo.
- [x] Finalizar el Rest controller de los Huevos y sus respectivos services y repo.
- [x] Generar una tabla clave valor de tipo diccionario, (Reference) en ella tendrá los precios de venta y "tiempo de vida de un huevo y gallina"
- [x] Verificar que todos los métodos de los controllers funcionan correctamente. 
- [x] Se agrega Swagger para documentación ( http://localhost:8080/swagger/dist/index.html#/ )
- [ ] Generar las clases DTO
- [ ] Generar una tabla clave valor de tipo diccionario donde tendrá los id de las granjas y de los usuarios asignados
- [ ] Generar dos tablas, una de transacciones y la otra con los detalles de las transacciones
- [ ] Seguir actualizando la lista
- [ ] Agregar algo interesante acá

# Creacion de la base de datos y sus respectivas tablas
<details>
  <summary>Click to expand!</summary>
 
 ```
   CREATE SCHEMA `farm-management` ;

   SET GLOBAL time_zone = '-3:00';

   CREATE TABLE `farm-management`.`farm` (
     `farm_id` INT NOT NULL AUTO_INCREMENT,
     `farm_name` VARCHAR(45) NOT NULL,
     `chicken_bought` INT NULL,
     `chicken_sold` INT NULL,
     `egg_bought` INT NULL,
     `egg_sold` INT NULL,
     `income` DOUBLE NULL,
     `expenses` DOUBLE NULL,
     PRIMARY KEY (`farm_id`),
     UNIQUE INDEX `farm_id_UNIQUE` (`farm_id` ASC) VISIBLE,
     UNIQUE INDEX `farm_name_UNIQUE` (`farm_name` ASC) VISIBLE);

   CREATE TABLE `farm-management`.`chicken` (
     `chicken_id` INT NOT NULL AUTO_INCREMENT,
     `farm_id` INT NOT NULL,
     `birth_date` DATE NULL,
     `expiration_date` DATE NULL,
     PRIMARY KEY (`chicken_id`));

   CREATE TABLE `farm-management`.`egg` (
     `egg_id` INT NOT NULL AUTO_INCREMENT,
     `farm_id` INT NOT NULL,
     `birth_date` DATE NULL,
     `expiration_date` DATE NULL,
     PRIMARY KEY (`egg_id`));

   CREATE TABLE `farm-management`.`reference` (
     `key` VARCHAR(45) NOT NULL,
     `value` VARCHAR(45) NULL);
  ```
     
</details>

# Datos de una granja JSON

- Datos ejemplo para un update completo. URL: http://localhost:8080/api/farms/1 Method:PUT
  - En caso de crear una granja nueva no incluir el farmId en el cuerpo ni en la url http://localhost:8080/api/farms Method: POST
```
{
    "farmId": 1,
    "farmName": "Test  Farm!",
    "chickenBought": 80,
    "chickenSold": 10,
    "eggBought": 0,
    "eggSold": 24,
    "income": 350,
    "expenses": 100
}
```

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
