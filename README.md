# ConversorDeMonedas
Challenge conversor de monedas Alura ONE G6

# Menú del programa

![image](https://github.com/AngelMendez1984/ConversorDeMonedas/assets/148590130/369d48d4-9b0d-4328-91f1-e12d94b9e994)

# Descripción

Conversor de Monedas es una aplicación basada en Java que permite a los usuarios convertir entre diferentes monedas utilizando tasas de cambio en tiempo real. La aplicación realiza solicitudes a una API externa para obtener las tasas de conversión más recientes y realiza los cálculos necesarios para convertir la cantidad deseada de una moneda a otra.

# Características

-Convertir entre varias monedas.

-Obtener tasas de cambio en tiempo real desde una API externa.

-Interfaz de usuario simple e intuitiva.

-Manejo de errores para entradas no válidas.

# Tecnologías Utilizadas

-Java.
-Cliente HTTP para solicitudes a la API.

-Análisis de JSON para manejar las respuestas de la API.


# Prerrequisitos

-JDK 11 o superior

-Conexión a Internet para obtener tasas de cambio en tiempo real

-Es necesario agregar el archivo jar de Gson para que el proyecto funcione correctamente. El cúal se encuentra en la siguiente URL https://repo1.maven.org/maven2/com/google/code/gson/gson/2.11.0/gson-2.11.0.jar

# Uso
1. Ejecuta la aplicación.
2. Elige la conversión que deseas realizar.
3. Ingresa el monto a convertir.
4. Se indica la equivalencia de la moneda base a la moneda objetivo.

# La aplicación maneja varios errores tales como:

-Cantidades de entrada no válidas.

-Códigos de moneda no válidos.

-Fallos en las solicitudes a la API.
