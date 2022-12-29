import React from 'react';

function Ul({category}) {
    return (
        <ul>
            {
                category.map(c => <li key={c.id}> {c.name} </li>)
            }
        </ul>
    );
}

export default Ul;