import React from 'react'
import Element from './Element';

const List = React.memo(({ handleClick, myBudget, setMyBudget }) => {

    return (
        <div>
            {myBudget.map((data, index) => (
                <Element 
                    key={data.id}
                    id={data.id}
                    content={data.content}
                    cost={data.cost}
                    myBudget={myBudget}
                    setMyBudget={setMyBudget}
                    handleClick={handleClick}
                />
            ))}
        </div>
    )
})

export default List;
