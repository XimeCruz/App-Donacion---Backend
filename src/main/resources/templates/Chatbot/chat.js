document.addEventListener("DOMContentLoaded", function() {
    const chatMessages = document.querySelector('.chat-messages');
    const chatInput = document.querySelector('.chat-input-field');
    const sendButton = document.querySelector('.chat-send-button');

    const handleUserInput = (input) => {
        const lowerInput = input.toLowerCase();
        if (lowerInput.includes('donar') || lowerInput.includes('donación')) {
            return 'como_donar';
        } else if (lowerInput.includes('que hace un voluntario') || lowerInput.includes('que realiza un voluntario') || lowerInput.includes('tiene un voluntario')) {
            return 'voluntarios';
        } else if (lowerInput.includes('voluntario')) {
            return 'ayuda_voluntario';
        } else if (lowerInput.includes('alimentos')) {
            return 'concientizacion';
        } else if (lowerInput.includes('donador') || lowerInput.includes('donante')) {
            return 'donadores';
        } else if (lowerInput.includes('receptor')) {
            return 'receptores';
        } else {
            return 'no_entendido';
        }
    };

    const steps = [
        {
            id: '0',
            message: '¡Bienvenido/a soy F4E BOT!',
            trigger: '1',
        },
        {
            id: '1',
            message: '¿Cómo puedo ayudarte hoy?',
            trigger: '2',
        },
        {
            id: '2',
            user: true,
            validator: (value) => {
                if (value.trim() === '') {
                    return 'Por favor, escribe algo para continuar.';
                }
                return true;
            },
            trigger: ({ value }) => handleUserInput(value),
        },
        {
            id: 'donadores',
            message: 'Los donadores son fundamentales para nuestra misión. Contribuyen con recursos y materiales para apoyar nuestros programas y actividades. ¡Gracias por ser parte de este esfuerzo!',
            trigger: '2',
        },
        {
            id: 'voluntarios',
            message: 'Los voluntarios son el corazón de nuestra organización. Ayudan en la distribución de alimentos, eventos comunitarios y otras actividades importantes. Si estás interesado en ser voluntario, por favor ponte en contacto con nosotros para más información.',
            trigger: '2',
        },
        {
            id: 'receptores',
            message: 'Los receptores son las personas y comunidades a las que servimos. Proporcionamos alimentos nutritivos y esenciales a aquellos que más lo necesitan, trabajando para aliviar la inseguridad alimentaria en nuestras comunidades.',
            trigger: '2',
        },
        {
            id: 'como_donar',
            message: 'Para donar, puedes visitar nuestra página web y seguir las instrucciones en la sección de donaciones. Agradecemos cualquier contribución que puedas hacer para apoyar nuestra misión.',
            trigger: '2',
        },
        {
            id: 'concientizacion',
            message: 'La concientización sobre la donación de alimentos es crucial para abordar la inseguridad alimentaria. Animamos a las personas a donar alimentos no perecederos a organizaciones benéficas locales y a participar en campañas de sensibilización sobre este tema importante.',
            trigger: '2',
        },
        {
            id: 'ayuda_voluntario',
            message: 'Si estás interesado en ayudar como voluntario, por favor visita nuestra página web o ponte en contacto con nosotros para conocer las oportunidades de voluntariado disponibles. ¡Tu ayuda es invaluable para nosotros!',
            trigger: '2',
        },
        {
            id: 'no_entendido',
            message: 'Lo siento, no entendí tu pregunta. ¿Podrías ser más específico?',
            trigger: '1',
        },
    ];

    const addMessageToChat = (message, isUser) => {
        const messageElement = document.createElement('div');
        messageElement.classList.add('chat-message');
        messageElement.classList.add(isUser ? 'user' : 'bot');
        messageElement.textContent = message;
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight;
    };

    const simulateTyping = () => {
        return new Promise(resolve => {
            setTimeout(resolve, Math.random() * 500 + 500); // Random delay between 500ms and 1000ms
        });
    };

    const handleSendMessage = async () => {
        const userInput = chatInput.value.trim();
        if (userInput) {
            addMessageToChat(userInput, true);
            chatInput.value = '';
            await simulateTyping();
            const triggerStep = steps.find((step) => step.id === handleUserInput(userInput));
            if (triggerStep) {
                const botMessage = triggerStep.message;
                await typeBotMessage(botMessage);
                const nextStep = steps.find((step) => step.id === triggerStep.trigger);
                if (nextStep && nextStep.user) {
                    chatInput.focus();
                }
            } else {
                await typeBotMessage('Lo siento, no entendí esa entrada.');
            }
        }
    };

    const typeBotMessage = async (message) => {
        const messageElement = document.createElement('div');
        messageElement.classList.add('chat-message');
        messageElement.classList.add('bot');
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight;
        for (let i = 0; i < message.length; i++) {
            await new Promise(resolve => setTimeout(resolve, 50)); // Typing speed: 50ms per character
            messageElement.textContent = message.substring(0, i + 1);
        }
    };

    // Agrega los mensajes de bienvenida al chat
    addMessageToChat('¡Bienvenido/a soy F4E BOT!', false);
    addMessageToChat('¿Cómo puedo ayudarte hoy?', false);

    sendButton.addEventListener('click', handleSendMessage);
    chatInput.addEventListener('keydown', (event) => {
        if (event.key === 'Enter') {
            handleSendMessage();
        }
    });
});
