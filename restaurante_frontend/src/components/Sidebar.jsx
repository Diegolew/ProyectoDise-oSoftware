import { Link, useLocation } from "react-router-dom";
import { useRestaurant } from "../context/RestaurantContext";

const Sidebar = () => {
  const location = useLocation();
  const { rol } = useRestaurant();
  
  const isActive = (path) => {
    return location.pathname === path;
  };

  // Definimos qué puede ver cada rol
  const PERMISOS = {
    Admin: ["/dashboard", "/tables", "/reservations", "/menu", "/orders", "/kitchen", "/delivery", "/billing", "/promotions", "/settings"],
    Recepcion: ["/dashboard", "/tables", "/reservations", "/delivery"],
    Mesero: ["/dashboard", "/tables", "/menu", "/orders", "/billing"],
    Cocina: ["/kitchen"],
    Cliente: ["/menu"]
  };

  // Lista de todos los menús posibles
  const menuItems = [
    { to: "/dashboard", icon: "📊", label: "Dashboard" },
    { to: "/tables", icon: "🪑", label: "Mesas" },
    { to: "/reservations", icon: "📅", label: "Reservas" },
    { to: "/menu", icon: "📜", label: "Menú" },
    { to: "/orders", icon: "📝", label: "Pedidos" },
    { to: "/kitchen", icon: "👨‍🍳", label: "Cocina" },
    { to: "/delivery", icon: "🛵", label: "Delivery" },
    { to: "/billing", icon: "🧾", label: "Facturación" },
    { to: "/promotions", icon: "🏷️", label: "Promociones" },
    { to: "/settings", icon: "⚙️", label: "Configuración" },
  ];

  return (
    <div className="w-64 bg-vino-800 h-screen text-white flex flex-col fixed left-0 top-0 border-r border-vino-900 shadow-xl z-50 transition-all duration-300">
      <div className="p-6 text-2xl font-bold flex items-center gap-2 border-b border-vino-900 bg-vino-900/50">
        <span>🍽️ La Mesa</span>
      </div>
      
      <nav className="flex-1 p-4 space-y-2 overflow-y-auto">
        {menuItems.map((item) => {
           // Verificamos si el usuario actual tiene permiso para ver este link
           const tienePermiso = PERMISOS[rol]?.includes(item.to);
           
           if (!tienePermiso) return null; // Si no tiene permiso, no renderizamos nada

           return (
             <MenuItem 
                key={item.to}
                to={item.to} 
                icon={item.icon} 
                label={item.label} 
                active={isActive(item.to)} 
             />
           );
        })}
      </nav>
      
      <div className="p-4 m-4 bg-vino-900/80 rounded-xl border border-vino-700">
        <p className="text-[10px] text-gray-400 uppercase font-bold mb-1">Rol actual</p>
        <p className="text-lg font-bold text-white capitalize">{rol}</p>
      </div>

      <div className="p-2 bg-vino-950 text-[10px] text-center text-gray-500">
        v1.0
      </div>
    </div>
  );
};

const MenuItem = ({ to, icon, label, active }) => (
  <Link
    to={to}
    className={`w-full text-left p-3 rounded-lg flex items-center gap-3 transition-all duration-200 ${
      active 
        ? "bg-white text-vino-800 font-bold shadow-md translate-x-1" 
        : "text-gray-200 hover:bg-vino-700 hover:text-white"
    }`}
  >
    <span className="text-xl">{icon}</span>
    <span>{label}</span>
  </Link>
);

export default Sidebar;