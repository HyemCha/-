const list = document.getElementById('todo-list')
const createBtn = document.getElementById('create-btn')

let todos = []

createBtn.addEventListener('click', createNewTodo)

function createNewTodo() {
    // 새로운 아이템 객체 생성
    const item = {
        id: new Date().getTime(),
        text: '',
        complete: false
    }

    // 배열 처음에 새로운 아이템을 추가
    todos.unshift(item)

    // create Eelement
    const {itemEl, inputEl, removeBtnEl, editBtnEl} = createTodoElement(item)


    // 첫번째 자식 앞에 방금 생성한 아이템 추가
    list.prepend(itemEl)

    inputEl.removeAttribute('disabled')
    inputEl.focus()

    // 이벤트 등록
    
}

// 요소 생성하기
function createTodoElement(item) {
    const itemEl = document.createElement('div')
    itemEl.classList.add('item')

    const checkboxEl = document.createElement('input')
    checkboxEl.type = 'checkbox'

    if (item.complete) {
        itemEl.classList.add('complete')

    }

    const inputEl = document.createElement('input')
    inputEl.type = 'text'
    inputEl.value = item.text
    inputEl.setAttribute('disabled', '')

    const actionsEl = document.createElement('div')
    actionsEl.classList.add('actions')
    
    const editBtnEl = document.createElement('button')
    editBtnEl.classList.add('material-icons')
    editBtnEl.innerText = 'edit'

    const removeBtnEl = document.createElement('button')
    removeBtnEl.classList.add('material-icons', 'remove-btn')
    removeBtnEl.innerText = 'remove-circles'

    checkboxEl.addEventListener('change', () => {
        item.complete = checkboxEl.checked

        if(item.complete) {
            itemEl.classList.add('complete')
        } else {
            itemEl.classList.remove('complete')
        }
    })

    inputEl.addEventListener('blur', () => {
        inputEl.setAttribute('disabled', '')
    })

    inputEl.addEventListener('input', () => {
        item.text = inputEl.value
    })

    editBtnEl.addEventListener('click', () => {
        inputEl.removeAttribute('disabled')
        inputEl.focus()
    })

    removeBtnEl.addEventListener('click', () => {
        todos = todos.filter(t => t.id !== item.id)
        itemEl.remove()
    })

    actionsEl.appendChild(editBtnEl)
    actionsEl.appendChild(removeBtnEl)

    itemEl.appendChild(checkboxEl)
    itemEl.appendChild(inputEl)
    itemEl.appendChild(actionsEl)
    
    return {itemEl, inputEl, removeBtnEl, editBtnEl}
}