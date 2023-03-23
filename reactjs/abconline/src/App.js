import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';
import FetchAllProducts from './components/FetchAllProducts';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/product/all" element={<FetchAllProducts />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
