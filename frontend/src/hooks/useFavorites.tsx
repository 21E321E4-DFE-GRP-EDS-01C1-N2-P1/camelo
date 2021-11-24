import { createContext, ReactNode, useContext, useEffect, useState } from "react";
import { toast } from "react-toastify";
import { ProductFormatted } from "../types";

interface FavoritesProviderProps {
  children: ReactNode;
}

interface FavoritesContextData {
  favorites: ProductFormatted[];
  handleAddProductToFavorites: (produto: ProductFormatted) => void;
  handleRemoveProductToFavorites: (produto: ProductFormatted) => void;
  handleFavorite: (produto: ProductFormatted) => void;
  favorited: boolean;
}

const FavoritesContext = createContext<FavoritesContextData>({} as FavoritesContextData);

export function FavoritesProvider({ children }: FavoritesProviderProps) {
  const [favorites, setFavorites] = useState<ProductFormatted[]>([]);
  const [favorited, setFavorited] = useState(true);

  useEffect(() => {
    const storagedFavorites = localStorage.getItem("@favorites");
    setFavorites(storagedFavorites ? JSON.parse(storagedFavorites) : []);
  }, []);

  function handleAddProductToFavorites(produto: ProductFormatted) {
    try {
      const updatedFavorites = [...favorites];
      const productExists = updatedFavorites.find(product => product.id === produto.id);

      if(!productExists) {
        const newProduct = {
          ...produto,
          favorited: true
        }
        updatedFavorites.push(newProduct);
        setFavorites(updatedFavorites);
        localStorage.setItem('@favorites', JSON.stringify(updatedFavorites));
        toast.success('Produto adicionado ao carrinho');
      } else {
        return;
      }
    } catch {
      toast.error('Erro na adição do produto');
    }
  }

  function handleRemoveProductToFavorites(produto: ProductFormatted) {
    try {
      const updatedFavorites = [...favorites];
      const productIndex = updatedFavorites.findIndex(product => product.id === produto.id);

      if(productIndex >= 0) {
        updatedFavorites.splice(productIndex, 1);
        setFavorites(updatedFavorites);
        localStorage.setItem('@favorites', JSON.stringify(updatedFavorites));
      } else {
        throw Error();
      }
    } catch {
      toast.error('Erro ao desfavoritar produto');
    }
  }

  function handleFavorite(produto: ProductFormatted) {
    setFavorited(!favorited);
    if(favorited) {
      handleAddProductToFavorites(produto);
    } else {
      handleRemoveProductToFavorites(produto);
    }
  }

  return (
      <FavoritesContext.Provider 
        value={{ 
          favorites, 
          handleAddProductToFavorites, 
          handleRemoveProductToFavorites,
          handleFavorite,
          favorited
        }}>
          {children}
      </FavoritesContext.Provider>
  );
}

export function useFavorites(): FavoritesContextData {
  return useContext(FavoritesContext);
}