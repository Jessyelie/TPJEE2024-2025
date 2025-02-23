import React from 'react';

function Modal({ isVisible, fncs, title, body, footer }: { isVisible: boolean, title?: string, body?: any, footer?: any, fncs?: any }) {
    fncs;

    return (
        <div className={`modal fade ${isVisible ? 'show d-block' : ''}`} tabIndex={-1} style={{ display: isVisible ? 'block' : 'none', backgroundColor: "rgba(0, 0, 0, 0.5)" }}>
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        {title && <h5 className="modal-title">{title}</h5>}
                        <button type="button" className="btn-close" onClick={() => fncs?.onClose()}></button>
                    </div>
                    {body && <div className="modal-body">{body}</div>}
                    {footer && <div className="modal-footer">{footer}</div>}
                </div>
            </div>
        </div>
    );
}

export default Modal;
