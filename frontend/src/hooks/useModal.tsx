import { createContext, ReactNode, useContext, useState } from "react";

interface ModalProviderProps {
  children: ReactNode;
}

interface ModalContextData {
  handleOpenNewModal: () => void;
  handleCloseNewModal: () => void;
  isNewModalOpen: boolean;
}

const ModalContext = createContext<ModalContextData>({} as ModalContextData);

export function ModalProvider({ children }: ModalProviderProps) {
  const [isNewModalOpen, setIsNewModalOpen] = useState(false);

  function handleOpenNewModal() {
    setIsNewModalOpen(true);
  }

  function handleCloseNewModal() {
    setIsNewModalOpen(false);
  }

  return (
    <ModalContext.Provider
      value={{
        handleOpenNewModal,
        handleCloseNewModal,
        isNewModalOpen
      }}
    >
      {children}
    </ModalContext.Provider>
  );
}

export function useModal() {
  return useContext(ModalContext);
}