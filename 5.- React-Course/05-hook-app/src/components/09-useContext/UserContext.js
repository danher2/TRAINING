import {createContext}  from 'react'

//Higher order component, le puedo colocar componentes hijos dentro de el
//esto es un compartidor de informacion
export const UserContext = createContext(null); //esto crea un context o informacion de otros componentes que lo vamos a exportar para usar en otro lugar