import React, { useCallback, useState } from 'react'
import List from '../../components/List';
import { Form } from '../../components/Form';

const initialBudgetList = localStorage.getItem('myBudget') ? JSON.parse(localStorage.getItem('myBudget')) : [];

export const Budget = () => {

    const [myBudget, setMyBudget] = useState(initialBudgetList)
    const [content, setContent] = useState('')
    const [cost, setCost] = useState(0)

    const handleClick = useCallback((id) => {
        let newBudget = myBudget.filter(data => data.id !== id)
        setMyBudget(newBudget)
        localStorage.setItem('myBudget', JSON.stringify(newBudget))
    }, [myBudget])

    const handleSubmit = e => {
        e.preventDefault()

        let newBudget = {
            id: Date.now(),
            content: content,
            cost: cost,
        }

        setMyBudget(prev => [...prev, newBudget])
        localStorage.setItem('myBudget', JSON.stringify([...myBudget, newBudget]))
        setContent('')
        setCost(0)
    }

    const handleRemoveClick = () => {
        setMyBudget([])
        localStorage.setItem('myBudget', JSON.stringify([]))
    }

    const totalBudget = () => {
        let total = 0;
        myBudget.map(data => total += Number(data.cost))
        return total;
    }

    return (
        <div className='flex items-center justify-center w-screen h-screen'>
            <div className='w-full p-6 m-4 bg-white rounded shadow lg:w-3/4 lg:max-w-lg'>
                <Form handleSubmit={handleSubmit} content={content} setContent={setContent} cost={cost} setCost={setCost} />
                <List handleClick={handleClick} myBudget={myBudget} setMyBudget={setMyBudget} />

                <div className=''>
                    총 금액: {totalBudget()}
                </div>
            </div>
        </div>
    )
}
