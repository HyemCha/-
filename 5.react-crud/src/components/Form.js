import React from 'react'

export const Form = ({ handleSubmit, content, setContent, cost, setCost }) => {

    const handleChange = e => {
        let target = e.target
        if (target.name == 'content')
            setContent(target.value)
        else
            setCost(target.value)
    }

    return (
        <form onSubmit={handleSubmit} className='flex pt-2'>
            <input 
                type="text"
                name='content'
                className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                placeholder='항목'
                value={content}
                onChange={handleChange}
            />
            <input 
                type="text"
                name='cost'
                className='w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow'
                placeholder='비용'
                value={cost}
                onChange={handleChange}
            />
            <input
                className='p-2 text-blue-400 border-2 border-blue-400 rounded hover:text-white hover:bg-blue-200'
                type="submit"
                value='입력하기'
            />
        </form>
    )
}
