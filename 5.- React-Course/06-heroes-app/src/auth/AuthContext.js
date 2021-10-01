import { createContext } from 'react';


//contexte para permitir compartir o establecer authReducer a lo largo de toda la app
//solo llamamos el create context, despues lo utilizaremos para al authReducer
//donde se coloca?
export const AuthContext = createContext();