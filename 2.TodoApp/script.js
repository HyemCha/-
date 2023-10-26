const list = document.getElementById('todo-list')
const completedlist = document.getElementById('completed-list')
const createBtn = document.getElementById('create-btn')
const ongoingCounts = document.getElementById('ongoing-count')
const completedCounts = document.getElementById('completed-count')

let todos = []

let date = new Date();
let ongoingLength;
let completedLength;

createBtn.addEventListener('click', createNewTodo)

// 생성한 요소를 노드에 붙이기
function createNewTodo() {
    // 새로운 아이템 객체 생성
    const item = {
        id: date.getTime(),
        text: '',
        date: '',
        complete: false
    }

    // 배열 처음에 새로운 아이템을 추가
    todos.unshift(item)
    ongoingTodos = [...todos]

    // create Eelement
    const {itemEl, inputEl, removeBtnEl, editBtnEl} = createTodoElement(item)


    // 첫번째 자식 앞에 방금 생성한 아이템 추가
    list.prepend(itemEl)


    inputEl.removeAttribute('disabled')
    inputEl.focus()

    saveToLocalStorage()
}

// 요소 생성하기 - 창이 새로 뜰 때, 요소가 새로 추가될 때 호출됨
function createTodoElement(item) {
    const itemEl = document.createElement('div')
    itemEl.classList.add('item')

    const checkboxEl = document.createElement('input')
    checkboxEl.type = 'checkbox'
    checkboxEl.checked = item.complete
    if (item.complete) {
        itemEl.classList.add('complete')
        console.log('처음에마 나옴')
    }

    const inputEl = document.createElement('input')
    inputEl.type = 'text'
    inputEl.value = item.text
    inputEl.setAttribute('disabled', '')

    const dateEl = document.createElement('span')
    dateEl.classList.add('date')
    let today = `${date.getFullYear()}/${date.getMonth() + 1}/${date.getDate()}`
    dateEl.innerText = today

    const actionsEl = document.createElement('div')
    actionsEl.classList.add('actions')
    
    const editBtnEl = document.createElement('button')
    editBtnEl.classList.add('material-icons','edit-btn')
    editBtnEl.innerText = 'edit'

    const removeBtnEl = document.createElement('button')
    removeBtnEl.classList.add('material-icons', 'remove-btn')
    removeBtnEl.innerText = 'delete'

    checkboxEl.addEventListener('change', () => {
        item.complete = checkboxEl.checked

        if(item.complete) {
            itemEl.classList.add('complete')
        } else {
            itemEl.classList.remove('complete')
        }
        changeParentList(itemEl, item)
        saveToLocalStorage()
    })

    inputEl.addEventListener('blur', () => {
        inputEl.setAttribute('disabled', '')
        saveToLocalStorage()
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
        saveToLocalStorage()
    })

    actionsEl.appendChild(editBtnEl)
    actionsEl.appendChild(removeBtnEl)

    itemEl.appendChild(checkboxEl)
    itemEl.appendChild(inputEl)
    itemEl.appendChild(dateEl)
    itemEl.appendChild(actionsEl)
    
    return {itemEl, inputEl, removeBtnEl, editBtnEl}
}

function changeParentList(itemEl, item) {
    if (item.complete){
        list.removeChild(itemEl)
        completedlist.append(itemEl)
    } else {
        completedlist.removeChild(itemEl)
        list.append(itemEl)
    }
    countTodos()
}

function countTodos() {
    ongoingLength = list.childElementCount
    completedLength = completedlist.childElementCount
    console.log(ongoingLength)
    console.log(completedLength)

    ongoingCounts.innerText = ongoingLength
    completedCounts.innerText = completedLength
}

function saveToLocalStorage() {
    const data = JSON.stringify(todos)

    window.localStorage.setItem('my_todos', data)
}

function loadFromLocalStorage() {
    const data = localStorage.getItem('my_todos')
    
    if(data) {
        todos = JSON.parse(data)
    }
}

function displayTodos() {
    loadFromLocalStorage();
    
    for(let i = 0; i < todos.length; i++) {
        const item = todos[i]
        const { itemEl } = createTodoElement(item)

        // list.appendChild(itemEl)

        if (item.complete) {
            completedlist.appendChild(itemEl)
        } else {
            list.appendChild(itemEl)
        }
    }

    countTodos()
}

// 새로고침 될 때 보여줌
displayTodos()
