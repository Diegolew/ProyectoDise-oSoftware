import { useState } from "react";
import { useRestaurant } from "../context/RestaurantContext";

const TopBar = ({ title, subtitle, showRoleSelector = true }) => {
    const { rol, setRol } = useRestaurant();
    const [menuAbierto, setMenuAbierto] = useState(false);

    return (
        <header className="mb-8 flex justify-between items-start">
            <div>
                <h1 className="text-3xl font-bold text-gray-800 font-serif">{title}</h1>
                {subtitle && <p className="text-gray-500 mt-1">{subtitle}</p>}
            </div>

            <div className="flex items-center gap-4">
                {showRoleSelector && (
                    <div className="relative">
                        <button 
                            onClick={() => setMenuAbierto(!menuAbierto)}
                            className={`flex items-center gap-3 bg-white border px-4 py-2 rounded-lg shadow-sm transition-colors ${
                                menuAbierto ? 'bg-gray-50 border-gray-300' : 'border-gray-200 hover:bg-gray-50'
                            }`}
                        >
                            <div className="text-right">
                                <p className="text-xs text-gray-400 font-bold uppercase">Rol actual</p>
                                <p className="text-sm font-bold text-gray-800 capitalize">{rol}</p>
                            </div>
                            <span className="text-gray-400">▼</span>
                        </button>

                        {/* Menú Dropdown*/}
                        {menuAbierto && (
                            <div className="absolute right-0 top-full mt-2 w-48 bg-white border border-gray-100 rounded-xl shadow-xl p-2 z-50 animate-fade-in">
                                {["Admin", "Recepcion", "Mesero", "Cocina", "Cliente"].map((r) => (
                                    <button 
                                        key={r}
                                        onClick={() => {
                                            setRol(r);
                                            setMenuAbierto(false);
                                        }}
                                        className={`w-full text-left px-3 py-2 rounded-lg text-sm transition-colors ${
                                            rol === r ? "bg-vino-50 text-vino-900 font-bold" : "text-gray-600 hover:bg-gray-50"
                                        }`}
                                    >
                                        {r}
                                    </button>
                                ))}
                            </div>
                        )}
                    </div>
                )}
                
            </div>
        </header>
    );
};

export default TopBar;