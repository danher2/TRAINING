import React, { useContext } from 'react'
import { UserContext } from './UserContext'

export const AboutScreen = () => {

    const { user, setuser } = useContext(UserContext);


    const handleClick = () => {

        setuser({})
    }


    return (
        <div>
            <h1>AboutScreen</h1>
            <hr />

            <pre>
                {JSON.stringify(user, null, 3)}
            </pre>
            <button className="btn btn-primary"
                onClick={handleClick}
            >LogOut
            </button>

        </div>
    )
}
