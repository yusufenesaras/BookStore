import Dashboard from "./components/Dashboard";
import Navbar from "./components/Navbar";
import Announcement from "./components/Announcement";
import Newsletter from "./components/Newsletter";
import Footer from "./components/Footer";
import Slider from "./components/Slider";
const App = () => {
  return (
    <div>
      <Announcement />
      <Navbar />
      <Slider/>
      <Dashboard />
      <Newsletter />
      <Footer />
    </div>
  );
};

export default App;
