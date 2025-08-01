-- 1. Holder (Holder) Table
CREATE TABLE Deposit_Holder (
    pan VARCHAR(20) PRIMARY KEY,
    type VARCHAR(20),
    address VARCHAR(255),
    ckyc_compliance BOOLEAN,
    dob DATE,
    email VARCHAR(100),
    landline VARCHAR(15),
    mobile VARCHAR(15),
    name VARCHAR(100),
    nominee VARCHAR(50)
);

-- 2. Summary Table
CREATE TABLE Deposit_Summary (
    micr_code VARCHAR(20) PRIMARY KEY,  -- Unique identifier for summary
    pan VARCHAR(20),
    balance_datetime DATETIME,
    branch VARCHAR(100),
    currency VARCHAR(10),
    current_balance DECIMAL(15,2),
    current_od_limit DECIMAL(15,2),
    drawing_limit DECIMAL(15,2),
    exchange_rate DECIMAL(10,4),
    facility VARCHAR(50),
    ifsccode VARCHAR(20),
    opening_date DATE,
    status VARCHAR(20),
    type VARCHAR(20),
    FOREIGN KEY (pan) REFERENCES Holder(pan)
);

-- 3. Transaction Table
CREATE TABLE Deposit_Transaction (
    transaction_id VARCHAR(50) PRIMARY KEY,
    pan VARCHAR(20),
    amount DECIMAL(15,2),
    current_balance DECIMAL(15,2),
    mode VARCHAR(20),
    narration VARCHAR(255),
    reference VARCHAR(50),
    transaction_timestamp DATETIME,
    type VARCHAR(20),
    valuedate DATETIME,
    FOREIGN KEY (pan) REFERENCES Holder(pan)
);




------------------------------------------------------------------------------------------------------------------




-- 1. Mutual Fund Holder 
CREATE TABLE MF_Holder (
    pan VARCHAR(20) PRIMARY KEY,
    address VARCHAR(255),
    dematId VARCHAR(30),
    dob DATE,
    email VARCHAR(100),
    folioNo VARCHAR(30),
    kycCompliance BOOLEAN,
    landline VARCHAR(15),
    mobile VARCHAR(15),
    name VARCHAR(100),
    nominee BOOLEAN
);

-- 2. Mutual Fund Holdings (Summary)
CREATE TABLE MF_Holdings (
    folioNo VARCHAR(30) PRIMARY KEY,
    pan VARCHAR(20),
    costValue DECIMAL(15,2),
    currentValue DECIMAL(15,2),
    FatcaStatus BOOLEAN,
    amc VARCHAR(100),
    amfiCode VARCHAR(20),
    closingUnits DECIMAL(15,4),
    isin VARCHAR(20),
    isinDescription VARCHAR(255),
    lienUnits DECIMAL(15,4),
    lockinUnits DECIMAL(15,4),
    nav DECIMAL(10,4),
    navDate DATE,
    registrar VARCHAR(100),
    schemeCategory VARCHAR(50),
    schemeCode VARCHAR(20),
    schemeOption VARCHAR(20),
    schemeTypes VARCHAR(50),
    ucc VARCHAR(30),
    FOREIGN KEY (pan) REFERENCES MF_Holder(pan)
);

-- 3. Mutual Fund Transactions
CREATE TABLE MF_Transactions (
    txnId VARCHAR(50) PRIMARY KEY,
    folioNo VARCHAR(30),
    amc VARCHAR(100),
    amfiCode VARCHAR(20),
    amount DECIMAL(15,2),
    isin VARCHAR(20),
    isinDescription VARCHAR(255),
    lock_inDays INT,
    lock_inFlag BOOLEAN,
    mode VARCHAR(20),
    narration VARCHAR(255),
    nav DECIMAL(10,4),
    navDate DATE,
    registrar VARCHAR(100),
    schemeCode VARCHAR(20),
    schemePlan VARCHAR(50),
    transactionDate DATE,
    type VARCHAR(10), -- BUY or SELL
    ucc VARCHAR(30),
    units DECIMAL(15,4),
    FOREIGN KEY (folioNo) REFERENCES MF_Holdings(folioNo)
);



----------------------------------------------------------------------------------------------------------------


-- 1. Equity Holder 
CREATE TABLE Equity_Holder (
    pan VARCHAR(20) PRIMARY KEY,
    address VARCHAR(255),
    dematId VARCHAR(30),
    dob DATE,
    email VARCHAR(100),
    kycCompliance BOOLEAN,
    landline VARCHAR(15),
    mobile VARCHAR(15),
    name VARCHAR(100),
    nominee BOOLEAN
);

-- 2. Equity Holdings Summary
CREATE TABLE Equity_Holdings (
    isin VARCHAR(20) PRIMARY KEY,            -- unique for each security
    pan VARCHAR(20),
    currentValue DECIMAL(15,2),
    holdingMode VARCHAR(20),
    isinDescription VARCHAR(255),
    issuerName VARCHAR(100),
    lastTradedPrice DECIMAL(15,2),
    units DECIMAL(15,4),
    FOREIGN KEY (pan) REFERENCES Equity_Holder(pan)
);

-- 3. Equity Transactions
CREATE TABLE Equity_Transactions (
    txnId VARCHAR(50) PRIMARY KEY,           -- unique transaction id
    pan VARCHAR(20),
    companyName VARCHAR(100),
    equityCategory VARCHAR(20),
    exchange VARCHAR(20),
    isin VARCHAR(20),
    isinDescription VARCHAR(255),
    narration VARCHAR(255),
    orderId VARCHAR(50),
    rate DECIMAL(15,2),
    transactionDateTime DATETIME,
    type VARCHAR(10),                         -- BUY or SELL
    units DECIMAL(15,4),
    FOREIGN KEY (pan) REFERENCES Equity_Holder(pan),
    FOREIGN KEY (isin) REFERENCES Equity_Holdings(isin)
);

----------------------------------------------------------------------------------------------------------


CREATE TABLE Client_Consent_Mapping (
    ClientCode      VARCHAR(50) NOT NULL,     -- Application number / unique client code
    PAN             VARCHAR(20) NOT NULL,     -- PAN number of client
    DOB             DATE,                     -- Date of birth
    Email           VARCHAR(100),             -- Email address of client
    RequestId       VARCHAR(100),             -- Request ID returned from Finarkein API
    ConsentHandle   VARCHAR(100),             -- Consent handle returned from Finarkein API
    State           VARCHAR(20) NOT NULL,     -- Current state (e.g., Success, Pending)
    ConsentStatus   VARCHAR(20) NOT NULL,     -- Consent active/inactive
    DataFetchStatus VARCHAR(20) NOT NULL,     -- Status of data fetch (Success, Pending, Failed)
    RunType         VARCHAR(20),              -- Indicates type of run (Consent or Recurring)
    
    PRIMARY KEY (ClientCode, PAN, State, ConsentStatus, DataFetchStatus)
);

-------------------------------------------------------------------------------------------------------------


CREATE TABLE Client_Consent_Mapping_Hist  (
    ClientCode      VARCHAR(50) NOT NULL,     -- Application number / unique client code
    PAN             VARCHAR(20) NOT NULL,     -- PAN number of client
    DOB             DATE,                     -- Date of birth
    Email           VARCHAR(100),             -- Email address of client
    RequestId       VARCHAR(100),             -- Request ID returned from Finarkein API
    ConsentHandle   VARCHAR(100),             -- Consent handle returned from Finarkein API
    State           VARCHAR(20) NOT NULL,     -- Current state (e.g., Success, Pending)
    ConsentStatus   VARCHAR(20) NOT NULL,     -- Consent active/inactive
    DataFetchStatus VARCHAR(20) NOT NULL,     -- Status of data fetch (Success, Pending, Failed)
    RunType         VARCHAR(20),              -- Indicates type of run (Consent or Recurring)
    LastUpdatedTime TIMESTAMP NOT NULL,       -- Timestamp of the latest update for historical tracking
    
    PRIMARY KEY (ClientCode, PAN, State, ConsentStatus, DataFetchStatus, LastUpdatedTime)
);


