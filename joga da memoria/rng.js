document.addEventListener('DOMContentLoaded', () => {
    // Constantes
    const TECLAS = ['a', 's', 'd', 'f'];
    const TEMPO_EXIBICAO = 700;

    // Elementos do DOM
    const panels = {
        a: document.getElementById('panel-a'),
        s: document.getElementById('panel-s'),
        d: document.getElementById('panel-d'),
        f: document.getElementById('panel-f')
    };

    const startBtn = document.getElementById('start-btn');
    const resetBtn = document.getElementById('reset-btn');
    const currentRoundEl = document.getElementById('current-round');
    const sequenceLengthEl = document.getElementById('sequence-length');
    const scoreEl = document.getElementById('score');
    const messageEl = document.getElementById('message');
    const roundDisplay = document.getElementById('round-display');

    // Variáveis do jogo
    let gameSequence = [];
    let playerSequence = [];
    let round = 0;
    let score = 0;
    let gameActive = false;
    let showingSequence = false;

    // Mostrar mensagem com estilo
    function showMessage(text, color = "#ecf0f1", shadow = "none") {
        
        messageEl.textContent = text;
        messageEl.style.color = color;
        messageEl.style.textShadow = shadow;
    }

    // Gerar sequência aleatória
    function generateSequence() {
        gameSequence = [];
        for (let i = 0; i < 16; i++) {
            const randomIndex = Math.floor(Math.random() * TECLAS.length);
            gameSequence.push(TECLAS[randomIndex]);
        }
    }

    // Atualizar UI
    function updateUI() {
        currentRoundEl.textContent = `${round}/16`;
        sequenceLengthEl.textContent = round;
        scoreEl.textContent = score;
        roundDisplay.textContent = round;
    }

    // Destacar painel
    function highlightPanel(key) {
        const panel = panels[key];
        if (!panel) return;

        panel.classList.add('highlight');
        setTimeout(() => {
            panel.classList.remove('highlight');
        }, TEMPO_EXIBICAO - 100);
    }

    // Desabilita clique em painéis
    function togglePanels(active) {
        Object.values(panels).forEach(panel => {
            panel.style.pointerEvents = active ? 'auto' : 'none';
            panel.classList.toggle('disabled', !active);
        });
    }

    // Mostrar sequência
    function showSequence() {
        if (!gameActive) return;

        showingSequence = true;
        togglePanels(false);
        showMessage(`Rodada ${round}: Memorize a sequência...`, "#3498db", "0 0 8px rgba(52, 152, 219, 0.6)");

        let index = 0;
        const interval = setInterval(() => {
            if (index >= round) {
                clearInterval(interval);
                showingSequence = false;
                setTimeout(() => {
                    showMessage(`Sua vez! Repita a sequência (${round} ${round === 1 ? 'tecla' : 'teclas'})`, "#f1c40f", "0 0 8px rgba(241, 196, 15, 0.6)");
                    togglePanels(true);
                }, 300);
                return;
            }

            highlightPanel(gameSequence[index]);
            index++;
        }, TEMPO_EXIBICAO);
    }

    // Verificar a sequência do jogador
    function checkPlayerSequence(key) {
        if (!gameActive || showingSequence || playerSequence.length >= round) return;

        highlightPanel(key);
        playerSequence.push(key);

        if (gameSequence[playerSequence.length - 1] !== key) {
    togglePanels(false);
    gameActive = false;

    showMessage("Game Over! Você errou a sequência.", "#e74c3c", "0 0 10px rgba(231, 76, 60, 0.6)");
    startBtn.textContent = "Recomeçar";
    startBtn.disabled = false;

    return;
}


        if (playerSequence.length === round) {
            score += round * 10;
            togglePanels(false);

            if (round === 16) {
                showMessage("Parabéns! Easter Egg ativado com sucesso!", "#2ecc71", "0 0 15px rgba(46, 204, 113, 0.8)");
                gameActive = false;
                startBtn.textContent = "Jogo Concluído";
                startBtn.disabled = true;
            } else {
                showMessage("Correto! Preparando próxima rodada...", "#2ecc71", "0 0 8px rgba(46, 204, 113, 0.6)");
                round++;
                playerSequence = [];
                setTimeout(showSequence, 1500);
            }

            updateUI();
        }
    }

    // Iniciar o jogo
    function startGame() {
        if (gameActive) return;

        generateSequence();
        round = 1;
        score = 0;
        playerSequence = [];
        gameActive = true;

        updateUI();
        showMessage("Observe a sequência...", "#f1c40f", "0 0 8px rgba(241, 196, 15, 0.4)");
        startBtn.textContent = "Jogo em Andamento";
        startBtn.disabled = true;

        setTimeout(showSequence, 1000);
    }

    // Reiniciar o jogo
    function resetGame() {
        gameActive = false;
        showingSequence = false;
        round = 0;
        score = 0;
        playerSequence = [];
        gameSequence = [];

        showMessage("Pressione Iniciar para começar o jogo!", "#f1c40f", "0 0 8px rgba(241, 196, 15, 0.4)");
        startBtn.textContent = "Iniciar Jogo";
        startBtn.disabled = false;
        updateUI();
        togglePanels(false);
    }

    // Event listeners
    startBtn.addEventListener('click', startGame);
    resetBtn.addEventListener('click', resetGame);

    // Clique nos painéis
    TECLAS.forEach(key => {
        panels[key].addEventListener('click', () => {
            checkPlayerSequence(key);
        });
    });

    // Teclado
    document.addEventListener('keydown', (e) => {
        if (!gameActive || showingSequence) return;
        const key = e.key.toLowerCase();
        if (TECLAS.includes(key)) {
            checkPlayerSequence(key);
        }
    });

    // Iniciar estado inicial da interface
    togglePanels(false);
    updateUI();
    showMessage("Pressione Iniciar para começar o jogo!", "#f1c40f", "0 0 8px rgba(241, 196, 15, 0.4)");
});
