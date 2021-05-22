const element = document.getElementById('drag')
const gesture = new DragEvent(element,
    ({ active, movement: [mx, my] }) => {
        setActive(active);
        anime({
            targets: element,
            translateX: active ? mx : 0,
            translateY: active ? my : 0,
            duration: active ? 0 : 1000
        });
    })

delete gesture