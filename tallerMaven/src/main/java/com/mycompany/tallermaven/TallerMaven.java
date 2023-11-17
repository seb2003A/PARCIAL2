public class TallerMaven {

    public static void main(String[] args) {
        Gson gson = new Gson();

        LinkedList<Automovil> automoviles = new LinkedList<>();
        LinkedList<Motocicleta> motos = new LinkedList<>();

        Automovil autoEjemplo = new Automovil( "Mazda", "3", "ZYX987", 4);
        automoviles.add(autoEjemplo);
         Spark.port(4567);

        Motocicleta motoEjemplo = new Motocicleta(600, "Honda", "CBR600", "XYZ789");
        motos.add(motoEjemplo);

        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        post("/agregarAutomovil", (req, res) -> {
            res.type("application/json");

            Automovil nuevoAuto = gson.fromJson(req.body(), Automovil.class);

            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });

        get("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (automovil != null) {
                return gson.toJson(automovil);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automovil no encontrado"));
            }
        });

        delete("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (automovil != null) {
                automoviles.remove(automovil);
                return gson.toJson(new SuccessResponse("Automóvil eliminado exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });

        post("/agregarMoto", (req, res) -> {
            res.type("application/json");

            Motocicleta nuevaMoto = gson.fromJson(req.body(), Motocicleta.class);

            motos.add(nuevaMoto);

            return gson.toJson(nuevaMoto);
        });

        get("/motos/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (motocicleta != null) {
                return gson.toJson(motocicleta);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });

        delete("/motos/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (motocicleta != null) {
                motos.remove(motocicleta);
                return gson.toJson(new SuccessResponse("Motocicleta eliminada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });
        
put("/motos/:placa/entrada", (req, res) -> {
    res.type("application/json");

    String placa = req.params(":placa");

    Motocicleta motocicleta = motos.stream()
            .filter(m -> m.getPlaca().equals(placa))
            .findFirst()
            .orElse(null);

    if (motocicleta != null) {
        motocicleta.setHoraingreso(new Date());
        return gson.toJson(new SuccessResponse("Hora de entrada registrada exitosamente"));
    } else {
        res.status(404);
        return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
    }
});
    
        put("/automoviles/:id/salida", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (automovil != null) {
                automovil.setHorasalida(new Date());
                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        put("/motos/:placa/salida", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (motocicleta != null) {
                motocicleta.setHorasalida(new Date());
                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente"));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });
         get("/automoviles/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (automovil != null) {
                return gson.toJson(automovil);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

        get("/motos/:placa", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Motocicleta motocicleta = motos.stream()
                    .filter(m -> m.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (motocicleta != null) {
                return gson.toJson(motocicleta);
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Motocicleta no encontrada"));
            }
        });

        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });
         put("/automoviles/:placa/salida", (req, res) -> {
            res.type("application/json");

            String placa = req.params(":placa");

            Automovil automovil = automoviles.stream()
                    .filter(a -> a.getPlaca().equals(placa))
                    .findFirst()
                    .orElse(null);

            if (automovil != null) {
                automovil.setHorasalida(new Date());

                long tiempoEstacionamiento = automovil.getHorasalida().getTime() - automovil.getHoraingreso().getTime();

             
                double tarifaPorHora = 0.1;
                double tarifa = tiempoEstacionamiento * tarifaPorHora;

              
                automovil.setTarifa(tarifa);

                return gson.toJson(new SuccessResponse("Hora de salida registrada exitosamente. Tarifa: $" + tarifa));
            } else {
                res.status(404);
                return gson.toJson(new ErrorResponse("Automóvil no encontrado"));
            }
        });

       
        get("/reporte-ganancias", (req, res) -> {
            res.type("application/json");

            
            double gananciaTotal = automoviles.stream()
                    .mapToDouble(Automovil::getTarifa)
                    .sum();

       
            gananciaTotal += motos.stream()
                    .mapToDouble(Motocicleta::getTarifa)
                    .sum();

            return gson.toJson(new GananciasResponse("Ganancia total: $" + gananciaTotal));
        });

    }
    
}

            return gson.toJson(new GananciasResponse("Ganancia total: $" + gananciaTotal));
        });

    }
    
}
