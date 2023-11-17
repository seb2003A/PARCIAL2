package com.mycompany.tallermaven;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.Date;
import java.util.LinkedList;
import spark.Spark;


public class TallerMaven {

    public static void main(String[] args) {
        Gson gson = new Gson();

        LinkedList<Automovil> automoviles = new LinkedList<>();
        LinkedList<Motocicleta> motos = new LinkedList<>();

        // agregamos un automóvil de ejemplo
        Automovil autoEjemplo = new Automovil( "Mazda", "3", "ZYX987", 4);
        automoviles.add(autoEjemplo);
         Spark.port(4567);

        // agregamos una motocicleta de ejemplo
        Motocicleta motoEjemplo = new Motocicleta(600, "Honda", "CBR600", "XYZ789");
        motos.add(motoEjemplo);

        // endpoint para obtener la lista de automoviles
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        // endpoint para agregar un automovil
        post("/agregarAutomovil/:marca/:modelo/:placa/:numeropuertas", (req, res) -> {
            res.type("application/json");

            // Convertimos el json del cuerpo de la solicitud a un objeto Automovil
            Automovil nuevoAuto = gson.fromJson(req.body(), Automovil.class);

            // Añadimos el automovil al parqueadero
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });

        // Endpoint para obtener información de un automóvil específico por su placa
        get("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar el automóvil por ID
            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si el automóvil fue encontrado
            if (automovil != null) {
                return gson.toJson(automovil);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automovil no encontrado"));
            }
        });

        // Endpoint para eliminar un automóvil por su placa
        delete("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar el automóvil por placa
            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si el automóvil fue encontrado
            if (automovil != null) {
                automoviles.remove(automovil);
                return gson.toJson(new SuccessResponse("Automóvil eliminado exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        // Endpoint para obtener la lista de motocicletas
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        // Endpoint para agregar una motocicleta
        post("/agregarMoto", (req, res) -> {
            res.type("application/json");

            // Convertimos el JSON del cuerpo de la solicitud a un objeto Motocicleta
            Motocicleta nuevaMoto = gson.fromJson(req.body(), Motocicleta.class);

            // Añadimos la motocicleta al parqueadero
            motos.add(nuevaMoto);

            return gson.toJson(nuevaMoto);
        });

        // Endpoint para obtener información de una motocicleta específica por su placa
        get("/motos/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar la motocicleta por placa
            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si la motocicleta fue encontrada
            if (motocicleta != null) {
                return gson.toJson(motocicleta);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });

        // Endpoint para eliminar una motocicleta por su placa
        delete("/motos/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar la motocicleta por placa
            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si la motocicleta fue encontrada
            if (motocicleta != null) {
                motos.remove(motocicleta);
                return gson.toJson(new SuccessResponse("Motocicleta eliminada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });
        
        // Endpoint para registrar la hora de entrada de una motocicleta
put("/motos/:placa/entrada", (req, res) -> {
    res.type("application/json");

    // Obtener parámetro de la URL
    String placa = req.params(":placa");

    // Buscar la motocicleta por ID
    Motocicleta motocicleta = motos.stream()
            .filter(m -> m.getPlaca().equals(placa))
            .findFirst()
            .orElse(null);

    // Verificar si la motocicleta fue encontrada
    if (motocicleta != null) {
        // Registrar la hora de entrada
        motocicleta.setHoraingreso(new Date());
        return gson.toJson(new SuccessResponse("Hora de entrada registrada exitosamente"));
    } else {
        res.status(404);
        return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
    }
});
    
          // Endpoint para registrar la hora de salida de un automóvil
        put("/automoviles/:id/salida", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar el automóvil por ID
            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si el automóvil fue encontrado
            if (automovil != null) {
                // Registrar la hora de salida
                automovil.setHorasalida(new Date());
                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        // Endpoint para registrar la hora de salida de una motocicleta
        put("/motos/:placa/salida", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar la motocicleta por ID
            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si la motocicleta fue encontrada
            if (motocicleta != null) {
                // Registrar la hora de salida
                motocicleta.setHorasalida(new Date());
                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });
         get("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar el automóvil por ID
            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si el automóvil fue encontrado
            if (automovil != null) {
                return gson.toJson(automovil);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        // Endpoint para obtener información de una motocicleta por su ID
        get("/motos/:placa", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar la motocicleta por ID
            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si la motocicleta fue encontrada
            if (motocicleta != null) {
                return gson.toJson(motocicleta);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });

        // Endpoint para obtener la lista de todos los automóviles en el parqueadero
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        // Endpoint para obtener la lista de todas las motocicletas en el parqueadero
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });
         put("/automoviles/:placa/salida", (req, res) -> {
            res.type("application/json");

            // Obtener parámetro de la URL
            String placa = req.params(":placa");

            // Buscar el automóvil por ID
            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            // Verificar si el automóvil fue encontrado
            if (automovil != null) {
                // Registrar la hora de salida
                automovil.setHorasalida(new Date());

                // Calcular el tiempo de estacionamiento en milisegundos
                long tiempoEstacionamiento = automovil.getHorasalida().getTime() - automovil.getHoraingreso().getTime();

                // Calcular la tarifa (por ejemplo, $0.1 por milisegundo)
                double tarifaPorMilisegundo = 0.1;
                double tarifa = tiempoEstacionamiento * tarifaPorMilisegundo;

                // Puedes registrar la tarifa en el objeto Automovil si es necesario
                automovil.setTarifa(tarifa);

                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente. Tarifa: $" + tarifa));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        // Endpoint para generar un reporte de ganancias
        get("/reporte-ganancias", (req, res) -> {
            res.type("application/json");

            // Calcular la ganancia total sumando las tarifas de todos los vehículos
            double gananciaTotal = automoviles.stream()
                    .mapToDouble(Automovil::getTarifa)
                    .sum();

            // Puedes hacer lo mismo para las motocicletas si también tienen tarifas
            gananciaTotal += motos.stream()
                    .mapToDouble(Motocicleta::getTarifa)
                    .sum();

            return gson.toJson(new GananciasResponse("Ganancia total: $" + gananciaTotal));
        });

    }
    
}
