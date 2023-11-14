import logo from './logo.svg';
import './App.css';
import { Outlet, Route, Routes } from 'react-router-dom';
import { Nav } from './components/Nav';
import { Main } from './pages/MainPage'
import { Budget } from './pages/BudgetPage';

const Layout = () => {
  return (
    <div className='flex flex-col items-center justify-center  w-screen h-screen bg-blue-100'>
      <Nav />
      <Outlet />
    </div>
  )
}

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Layout />} >
          <Route index element={<Main />} />
          <Route path='budget' element={<Budget />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
