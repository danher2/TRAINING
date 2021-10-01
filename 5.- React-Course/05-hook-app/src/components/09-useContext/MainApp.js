import React, { useState } from 'react'
import { AppRouter } from './AppRouter'
import { UserContext } from './UserContext'

export const MainApp = () => {


    const [user, setuser] = useState({})

    return (
        // Cualquier informacion que se fije en UserContex va a estar disponible para Approuter y todos sus hijos
        <UserContext.Provider value = {{
            user,
            setuser,
         }}>
            <AppRouter />
        </UserContext.Provider>
    )
}
