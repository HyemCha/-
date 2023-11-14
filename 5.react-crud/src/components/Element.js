import React, { useState } from 'react'

const Element = React.memo((
    { id, content, cost, myBudget, setMyBudget, handleClick }
) => {

    const [isEditing, setIsEditing] = useState(false)
    const [editedContent, setEditedContent] = useState(content)
    const [editedCost, setEditedCost] = useState(cost)

    const handleEditChange = e => {
        let target = e.target
        if (target.name == 'content')
            setEditedContent(e.target.value)
        else
            setEditedCost(e.target.value)
    }

    const handleSubmit = e => {
        e.preventDefault()

        let newBudget = myBudget.map(data => {
            if (data.id === id) {
                data.content = editedContent
                data.cost = editedCost
            }
            return data;
        })

        setMyBudget(newBudget)
        setIsEditing(false)
        localStorage.setItem('myBudget', JSON.stringify(newBudget))
    }

    if (isEditing) {
        return (
            <div className={`bg-gray-100 flex items-center justify-between w-full px-4 py-1 my-2 text-gray-600  border rounded`}>
                <div className='items-center'>
                    <form onSubmit={handleSubmit} className='flex items-center justify-between'>
                        <input
                            name='content'
                            value={editedContent}
                            onChange={handleEditChange}
                            className='w-full px-3 py-2 mr-4 text-gray-500 rounded'
                        />
                        <input
                            name='cost'
                            value={editedCost}
                            onChange={handleEditChange}
                            className='w-full px-3 py-2 mr-4 text-gray-500 rounded'
                        />
                    </form>
                </div>
                <div className='items-center'>
                    <button onClick={() => setIsEditing(false)}>
                        x
                    </button>
                    <button type='submit' onClick={handleSubmit}>
                        save
                    </button>
                </div>
            </div>
        )
    } else {
        return (
            <div
                key={id}
                className="bg-white flex items-center justify-between w-full px-4 py-1 my-2 border rounded"
            >
                <div className="content flex-1 decoration-indigo-500/30">{content}</div>
                <div className="cost flex-1 decoration-indigo-500/30">{cost}</div>
                <div className='items-center'>
                    <button className='mr-2' onClick={() => setIsEditing(true)}>
                        edit
                    </button>
                    <button onClick={() => handleClick(id)}>
                        x
                    </button>
                </div>
            </div>
        )
    }
})

export default Element;