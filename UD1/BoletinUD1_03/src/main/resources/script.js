var poeta = {
  nombre: "Sylvia",
  apellidos: "Plath",
  estaViva: false,
  edad: 30,
  direccion: {
    direccionCalle: "21 2nd Street",
    ciudad: "New York",
    estado: "NY",
    codigoPostal: "10021-3100",
  },
  telefonos: [
    {
      tipo: "casa",
      numero: "212 555-1234",
    },
    {
      tipo: "oficina",
      numero: "646 555-4567",
    },
  ],
  hijos: [],
  marido: null,
};

console.log(poeta.nombre);
console.log(poeta.apellidos);
console.log(poeta.direccion.ciudad);
console.log(poeta.telefonos[1].numero);
