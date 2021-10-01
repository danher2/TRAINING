import React from 'react';
import { Provider } from 'react-redux';

import { store } from './store/store';
import { AppRouter } from './routers/AppRouter';

//Archivo general en el nivel mas alto
//aqui  se provee al appRouter toda la info del store

export const JournalApp = () => {
    return (
        <Provider store={ store }>
            <AppRouter />  {/* AppRouter es envuelto por Provider para proveer la informacion del store 
                            a sus componentes hijos, siempre se ponen en el nivel mas alto*/}
          </Provider>
    )
}
