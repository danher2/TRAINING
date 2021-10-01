import React from 'react';
import { Provider } from 'react-redux';

import { store } from './store/store';
import { AppRouter } from './router/AppRouter'

// despues del index crear un componente general de la app con el nombre la app
// esta es la que maneja el AppRouter
export const CalendarApp = () => {
    
    
    return (
        // este es el que proveee el store del patron Redux y se pone en el nivel mas alto de la app
        <Provider store={ store }> {/* provider recibe el store y es la informacion que le a todos los componnetes hijos de esta */}
            <AppRouter /> {/* AppRouter maneja la implementacion de las rutas (publicas y privadas, esta es envuelta por el provider) */}
        </Provider>
    )
}
