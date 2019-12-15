# language: es
# Author: juan.alvarezm@outlook.com
Característica: Lista de productos
  Como usuario de la plataforma de ebay
  quiero ingresar a la opción productos zapatos
  para realizar una consulta por precio y talla

  @End2End
  Esquema del escenario: Enumeración y lista de productos
    Dado que me encuentro en la pagina inicial de ebay
    Cuando ingreso el filtro por categoria <categoria>
    Y selecciono la marca <marca>
    Y selecciono la talla <talla>
    Entonces imprimir el numero de resultados
    Y ordenar por precio ascendente
    Y Tome los primeros <elementos> productos con sus precios e imprímalos en la consola
    Y Ordene e imprima los productos por nombre ascendente
    Y Ordene e imprima los productos por precio en modo descendiente

    Ejemplos: 
      | categoria | marca | talla |	elementos	|
      | zapatos   | PUMA  |	10 |	5	|
