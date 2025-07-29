package com.ashika.service.impl;

import com.ashika.model.dto.*;
import com.ashika.model.entity.*;
import com.ashika.repository.*;
import com.ashika.service.MyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyServiceImpl implements MyService {

    // ===== Repositories =====
    private final DepositProfileRepository depositProfileRepo;
    private final DepositSummaryRepository depositSummaryRepo;
    private final DepositTransactionRepository depositTransactionRepo;

    private final EquityProfileRepository equityProfileRepo;
    private final EquitySummaryRepository equitySummaryRepo;
    private final EquityTransactionRepository equityTransactionRepo;

    private final MFProfileRepository mfProfileRepo;
    private final MFSummaryRepository mfSummaryRepo;
    private final MFTransactionRepository mfTransactionRepo;

    private final ClientConsentMappingRepository clientConsentRepo;
    private final ClientConsentMappingHistRepository clientConsentHistRepo;

    public MyServiceImpl(DepositProfileRepository depositProfileRepo,
                         DepositSummaryRepository depositSummaryRepo,
                         DepositTransactionRepository depositTransactionRepo,
                         EquityProfileRepository equityProfileRepo,
                         EquitySummaryRepository equitySummaryRepo,
                         EquityTransactionRepository equityTransactionRepo,
                         MFProfileRepository mfProfileRepo,
                         MFSummaryRepository mfSummaryRepo,
                         MFTransactionRepository mfTransactionRepo,
                         ClientConsentMappingRepository clientConsentRepo,
                         ClientConsentMappingHistRepository clientConsentHistRepo) {
        this.depositProfileRepo = depositProfileRepo;
        this.depositSummaryRepo = depositSummaryRepo;
        this.depositTransactionRepo = depositTransactionRepo;
        this.equityProfileRepo = equityProfileRepo;
        this.equitySummaryRepo = equitySummaryRepo;
        this.equityTransactionRepo = equityTransactionRepo;
        this.mfProfileRepo = mfProfileRepo;
        this.mfSummaryRepo = mfSummaryRepo;
        this.mfTransactionRepo = mfTransactionRepo;
        this.clientConsentRepo = clientConsentRepo;
        this.clientConsentHistRepo = clientConsentHistRepo;
    }

    // ===================== Deposit Profile =====================
    @Override
    public List<DepositProfileDTO> getAllDepositProfiles() {
        return depositProfileRepo.findAll().stream()
                .map(this::toDepositProfileDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepositProfileDTO> getDepositProfileById(Long id) {
        return depositProfileRepo.findById(id).map(this::toDepositProfileDTO);
    }

    @Override
    public DepositProfileDTO saveDepositProfile(DepositProfileDTO dto) {
        DepositProfileEntity entity = toDepositProfileEntity(dto);
        return toDepositProfileDTO(depositProfileRepo.save(entity));
    }

    @Override
    public DepositProfileDTO updateDepositProfile(Long id, DepositProfileDTO dto) {
        DepositProfileEntity entity = depositProfileRepo.findById(id).orElseThrow();
        entity.setAccountNumber(dto.accountNumber());
        entity.setAccountType(dto.accountType());
        entity.setBankName(dto.bankName());
        entity.setBranch(dto.branch());
        entity.setIfsc(dto.ifsc());
        entity.setNominee(dto.nominee());
        entity.setPan(dto.pan());
        entity.setEmail(dto.email());
        entity.setMobile(dto.mobile());
        entity.setKycStatus(dto.kycStatus());
        return toDepositProfileDTO(depositProfileRepo.save(entity));
    }

    @Override
    public void deleteDepositProfile(Long id) {
        depositProfileRepo.deleteById(id);
    }

    // ===================== Deposit Summary =====================
    @Override
    public List<DepositSummaryDTO> getAllDepositSummaries() {
        return depositSummaryRepo.findAll().stream()
                .map(this::toDepositSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepositSummaryDTO> getDepositSummaryById(Long id) {
        return depositSummaryRepo.findById(id).map(this::toDepositSummaryDTO);
    }

    @Override
    public DepositSummaryDTO saveDepositSummary(DepositSummaryDTO dto) {
        DepositSummaryEntity entity = toDepositSummaryEntity(dto);
        return toDepositSummaryDTO(depositSummaryRepo.save(entity));
    }

    @Override
    public DepositSummaryDTO updateDepositSummary(Long id, DepositSummaryDTO dto) {
        DepositSummaryEntity entity = depositSummaryRepo.findById(id).orElseThrow();
        entity.setAccountNumber(dto.accountNumber());
        entity.setCurrentBalance(dto.currentBalance());
        entity.setInterestRate(dto.interestRate());
        entity.setMaturityDate(dto.maturityDate());
        return toDepositSummaryDTO(depositSummaryRepo.save(entity));
    }

    @Override
    public void deleteDepositSummary(Long id) {
        depositSummaryRepo.deleteById(id);
    }

    // ===================== Deposit Transaction =====================
    @Override
    public List<DepositTransactionDTO> getAllDepositTransactions() {
        return depositTransactionRepo.findAll().stream()
                .map(this::toDepositTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepositTransactionDTO> getDepositTransactionById(Long id) {
        return depositTransactionRepo.findById(id).map(this::toDepositTransactionDTO);
    }

    @Override
    public DepositTransactionDTO saveDepositTransaction(DepositTransactionDTO dto) {
        DepositTransactionEntity entity = toDepositTransactionEntity(dto);
        return toDepositTransactionDTO(depositTransactionRepo.save(entity));
    }

    @Override
    public DepositTransactionDTO updateDepositTransaction(Long id, DepositTransactionDTO dto) {
        DepositTransactionEntity entity = depositTransactionRepo.findById(id).orElseThrow();
        entity.setAmount(dto.amount());
        entity.setCurrentBalance(dto.currentBalance());
        entity.setMode(dto.mode());
        entity.setNarration(dto.narration());
        entity.setReference(dto.reference());
        entity.setTransactionId(dto.transactionId());
        entity.setTransactionTimestamp(dto.transactionTimestamp());
        entity.setType(dto.type());
        entity.setValueDate(dto.valueDate());
        return toDepositTransactionDTO(depositTransactionRepo.save(entity));
    }

    @Override
    public void deleteDepositTransaction(Long id) {
        depositTransactionRepo.deleteById(id);
    }

    // ===================== Equity Profile =====================
    @Override
    public List<EquityProfileDTO> getAllEquityProfiles() {
        return equityProfileRepo.findAll().stream()
                .map(this::toEquityProfileDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EquityProfileDTO> getEquityProfileById(Long id) {
        return equityProfileRepo.findById(id).map(this::toEquityProfileDTO);
    }

    @Override
    public EquityProfileDTO saveEquityProfile(EquityProfileDTO dto) {
        EquityProfileEntity entity = toEquityProfileEntity(dto);
        return toEquityProfileDTO(equityProfileRepo.save(entity));
    }

    @Override
    public EquityProfileDTO updateEquityProfile(Long id, EquityProfileDTO dto) {
        EquityProfileEntity entity = equityProfileRepo.findById(id).orElseThrow();
        entity.setAddress(dto.address());
        entity.setDematId(dto.dematId());
        entity.setDob(dto.dob());
        entity.setEmail(dto.email());
        entity.setKycCompliance(dto.kycCompliance());
        entity.setLandline(dto.landline());
        entity.setMobile(dto.mobile());
        entity.setName(dto.name());
        entity.setNominee(dto.nominee());
        entity.setPan(dto.pan());
        return toEquityProfileDTO(equityProfileRepo.save(entity));
    }

    @Override
    public void deleteEquityProfile(Long id) {
        equityProfileRepo.deleteById(id);
    }

    // ===================== Equity Summary =====================
    @Override
    public List<EquitySummaryDTO> getAllEquitySummaries() {
        return equitySummaryRepo.findAll().stream()
                .map(this::toEquitySummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EquitySummaryDTO> getEquitySummaryById(Long id) {
        return equitySummaryRepo.findById(id).map(this::toEquitySummaryDTO);
    }

    @Override
    public EquitySummaryDTO saveEquitySummary(EquitySummaryDTO dto) {
        EquitySummaryEntity entity = toEquitySummaryEntity(dto);
        return toEquitySummaryDTO(equitySummaryRepo.save(entity));
    }

    @Override
    public EquitySummaryDTO updateEquitySummary(Long id, EquitySummaryDTO dto) {
        EquitySummaryEntity entity = equitySummaryRepo.findById(id).orElseThrow();
        entity.setCurrentValue(dto.currentValue());
        entity.setHoldingMode(dto.holdingMode());
        entity.setIsin(dto.isin());
        entity.setIsinDescription(dto.isinDescription());
        entity.setIssuerName(dto.issuerName());
        entity.setLastTradedPrice(dto.lastTradedPrice());
        entity.setUnits(dto.units());
        return toEquitySummaryDTO(equitySummaryRepo.save(entity));
    }

    @Override
    public void deleteEquitySummary(Long id) {
        equitySummaryRepo.deleteById(id);
    }

    // ===================== Equity Transaction =====================
    @Override
    public List<EquityTransactionDTO> getAllEquityTransactions() {
        return equityTransactionRepo.findAll().stream()
                .map(this::toEquityTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EquityTransactionDTO> getEquityTransactionById(Long id) {
        return equityTransactionRepo.findById(id).map(this::toEquityTransactionDTO);
    }

    @Override
    public EquityTransactionDTO saveEquityTransaction(EquityTransactionDTO dto) {
        EquityTransactionEntity entity = toEquityTransactionEntity(dto);
        return toEquityTransactionDTO(equityTransactionRepo.save(entity));
    }

    @Override
    public EquityTransactionDTO updateEquityTransaction(Long id, EquityTransactionDTO dto) {
        EquityTransactionEntity entity = equityTransactionRepo.findById(id).orElseThrow();
        entity.setCompanyName(dto.companyName());
        entity.setEquityCategory(dto.equityCategory());
        entity.setExchange(dto.exchange());
        entity.setIsin(dto.isin());
        entity.setIsinDescription(dto.isinDescription());
        entity.setNarration(dto.narration());
        entity.setOrderId(dto.orderId());
        entity.setRate(dto.rate());
        entity.setTransactionDateTime(dto.transactionDateTime());
        entity.setTxnId(dto.txnId());
        entity.setType(dto.type());
        entity.setUnits(dto.units());
        return toEquityTransactionDTO(equityTransactionRepo.save(entity));
    }

    @Override
    public void deleteEquityTransaction(Long id) {
        equityTransactionRepo.deleteById(id);
    }

    // ===================== MF Profile =====================
    @Override
    public List<MFProfileDTO> getAllMFProfiles() {
        return mfProfileRepo.findAll().stream()
                .map(this::toMFProfileDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MFProfileDTO> getMFProfileById(Long id) {
        return mfProfileRepo.findById(id).map(this::toMFProfileDTO);
    }

    @Override
    public MFProfileDTO saveMFProfile(MFProfileDTO dto) {
        MFProfileEntity entity = toMFProfileEntity(dto);
        return toMFProfileDTO(mfProfileRepo.save(entity));
    }

    @Override
    public MFProfileDTO updateMFProfile(Long id, MFProfileDTO dto) {
        MFProfileEntity entity = mfProfileRepo.findById(id).orElseThrow();
        entity.setAddress(dto.address());
        entity.setDematId(dto.dematId());
        entity.setDob(dto.dob());
        entity.setEmail(dto.email());
        entity.setFolioNo(dto.folioNo());
        entity.setKycCompliance(dto.kycCompliance());
        entity.setLandline(dto.landline());
        entity.setMobile(dto.mobile());
        entity.setName(dto.name());
        entity.setNominee(dto.nominee());
        entity.setPan(dto.pan());
        return toMFProfileDTO(mfProfileRepo.save(entity));
    }

    @Override
    public void deleteMFProfile(Long id) {
        mfProfileRepo.deleteById(id);
    }

    // ===================== MF Summary =====================
    @Override
    public List<MFSummaryDTO> getAllMFSummaries() {
        return mfSummaryRepo.findAll().stream()
                .map(this::toMFSummaryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MFSummaryDTO> getMFSummaryById(Long id) {
        return mfSummaryRepo.findById(id).map(this::toMFSummaryDTO);
    }

    @Override
    public MFSummaryDTO saveMFSummary(MFSummaryDTO dto) {
        MFSummaryEntity entity = toMFSummaryEntity(dto);
        return toMFSummaryDTO(mfSummaryRepo.save(entity));
    }

    @Override
    public MFSummaryDTO updateMFSummary(Long id, MFSummaryDTO dto) {
        MFSummaryEntity entity = mfSummaryRepo.findById(id).orElseThrow();
        entity.setCostValue(dto.costValue());
        entity.setCurrentValue(dto.currentValue());
        entity.setFatcaStatus(dto.fatcaStatus());
        entity.setAmc(dto.amc());
        entity.setAmfiCode(dto.amfiCode());
        entity.setClosingUnits(dto.closingUnits());
        entity.setFolioNo(dto.folioNo());
        entity.setIsin(dto.isin());
        entity.setIsinDescription(dto.isinDescription());
        entity.setLienUnits(dto.lienUnits());
        entity.setLockinUnits(dto.lockinUnits());
        entity.setNav(dto.nav());
        entity.setNavDate(dto.navDate());
        entity.setRegistrar(dto.registrar());
        entity.setSchemeCategory(dto.schemeCategory());
        entity.setSchemeCode(dto.schemeCode());
        entity.setSchemeOption(dto.schemeOption());
        entity.setSchemeTypes(dto.schemeTypes());
        entity.setUcc(dto.ucc());
        return toMFSummaryDTO(mfSummaryRepo.save(entity));
    }

    @Override
    public void deleteMFSummary(Long id) {
        mfSummaryRepo.deleteById(id);
    }

    // ===================== MF Transaction =====================
    @Override
    public List<MFTransactionDTO> getAllMFTransactions() {
        return mfTransactionRepo.findAll().stream()
                .map(this::toMFTransactionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MFTransactionDTO> getMFTransactionById(Long id) {
        return mfTransactionRepo.findById(id).map(this::toMFTransactionDTO);
    }

    @Override
    public MFTransactionDTO saveMFTransaction(MFTransactionDTO dto) {
        MFTransactionEntity entity = toMFTransactionEntity(dto);
        return toMFTransactionDTO(mfTransactionRepo.save(entity));
    }

    @Override
    public MFTransactionDTO updateMFTransaction(Long id, MFTransactionDTO dto) {
        MFTransactionEntity entity = mfTransactionRepo.findById(id).orElseThrow();
        entity.setAmc(dto.amc());
        entity.setAmfiCode(dto.amfiCode());
        entity.setAmount(dto.amount());
        entity.setIsin(dto.isin());
        entity.setIsinDescription(dto.isinDescription());
        entity.setLockInDays(dto.lockInDays());
        entity.setLockInFlag(dto.lockInFlag());
        entity.setMode(dto.mode());
        entity.setNarration(dto.narration());
        entity.setNav(dto.nav());
        entity.setNavDate(dto.navDate());
        entity.setRegistrar(dto.registrar());
        entity.setSchemeCode(dto.schemeCode());
        entity.setSchemePlan(dto.schemePlan());
        entity.setTransactionDate(dto.transactionDate());
        entity.setTxnId(dto.txnId());
        entity.setType(dto.type());
        entity.setUcc(dto.ucc());
        entity.setUnits(dto.units());
        return toMFTransactionDTO(mfTransactionRepo.save(entity));
    }

    @Override
    public void deleteMFTransaction(Long id) {
        mfTransactionRepo.deleteById(id);
    }

    // ===================== Client Consent Mapping =====================
    @Override
    public List<ClientConsentMappingDTO> getAllClientConsents() {
        return clientConsentRepo.findAll().stream()
                .map(this::toClientConsentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientConsentMappingDTO> getClientConsentById(Long id) {
        return clientConsentRepo.findById(id).map(this::toClientConsentDTO);
    }

    @Override
    public ClientConsentMappingDTO saveClientConsent(ClientConsentMappingDTO dto) {
        ClientConsentMappingEntity entity = toClientConsentEntity(dto);
        return toClientConsentDTO(clientConsentRepo.save(entity));
    }

    @Override
    public ClientConsentMappingDTO updateClientConsent(Long id, ClientConsentMappingDTO dto) {
        ClientConsentMappingEntity entity = clientConsentRepo.findById(id).orElseThrow();
        entity.setClientCode(dto.clientCode());
        entity.setPan(dto.pan());
        entity.setDob(dto.dob());
        entity.setEmail(dto.email());
        entity.setRequestId(dto.requestId());
        entity.setConsentHandle(dto.consentHandle());
        entity.setState(dto.state());
        entity.setConsentStatus(dto.consentStatus());
        entity.setDataFetchStatus(dto.dataFetchStatus());
        return toClientConsentDTO(clientConsentRepo.save(entity));
    }

    @Override
    public void deleteClientConsent(Long id) {
        clientConsentRepo.deleteById(id);
    }

    // ===================== Client Consent Mapping History =====================
    @Override
    public List<ClientConsentMappingHistDTO> getAllClientConsentHistories() {
        return clientConsentHistRepo.findAll().stream()
                .map(this::toClientConsentHistDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientConsentMappingHistDTO> getClientConsentHistoryById(Long id) {
        return clientConsentHistRepo.findById(id).map(this::toClientConsentHistDTO);
    }

    @Override
    public ClientConsentMappingHistDTO saveClientConsentHistory(ClientConsentMappingHistDTO dto) {
        ClientConsentMappingHistEntity entity = toClientConsentHistEntity(dto);
        return toClientConsentHistDTO(clientConsentHistRepo.save(entity));
    }

    @Override
    public ClientConsentMappingHistDTO updateClientConsentHistory(Long id, ClientConsentMappingHistDTO dto) {
        ClientConsentMappingHistEntity entity = clientConsentHistRepo.findById(id).orElseThrow();
        entity.setClientCode(dto.clientCode());
        entity.setPan(dto.pan());
        entity.setDob(dto.dob());
        entity.setEmail(dto.email());
        entity.setRequestId(dto.requestId());
        entity.setConsentHandle(dto.consentHandle());
        entity.setState(dto.state());
        entity.setConsentStatus(dto.consentStatus());
        entity.setDataFetchStatus(dto.dataFetchStatus());
        entity.setLastUpdatedTime(dto.lastUpdatedTime());
        return toClientConsentHistDTO(clientConsentHistRepo.save(entity));
    }

    @Override
    public void deleteClientConsentHistory(Long id) {
        clientConsentHistRepo.deleteById(id);
    }

    // ===================== Conversion Methods =====================
    // Deposit Profile
    private DepositProfileDTO toDepositProfileDTO(DepositProfileEntity e) {
        return new DepositProfileDTO(e.getId(), e.getAccountNumber(), e.getAccountType(),
                e.getBankName(), e.getBranch(), e.getIfsc(), e.getNominee(), e.getPan(),
                e.getEmail(), e.getMobile(), e.getKycStatus());
    }

    private DepositProfileEntity toDepositProfileEntity(DepositProfileDTO d) {
        DepositProfileEntity e = new DepositProfileEntity();
        e.setId(d.id());
        e.setAccountNumber(d.accountNumber());
        e.setAccountType(d.accountType());
        e.setBankName(d.bankName());
        e.setBranch(d.branch());
        e.setIfsc(d.ifsc());
        e.setNominee(d.nominee());
        e.setPan(d.pan());
        e.setEmail(d.email());
        e.setMobile(d.mobile());
        e.setKycStatus(d.kycStatus());
        return e;
    }

    // Deposit Summary
    private DepositSummaryDTO toDepositSummaryDTO(DepositSummaryEntity e) {
        return new DepositSummaryDTO(e.getId(), e.getAccountNumber(), e.getCurrentBalance(),
                e.getInterestRate(), e.getMaturityDate());
    }

    private DepositSummaryEntity toDepositSummaryEntity(DepositSummaryDTO d) {
        DepositSummaryEntity e = new DepositSummaryEntity();
        e.setId(d.id());
        e.setAccountNumber(d.accountNumber());
        e.setCurrentBalance(d.currentBalance());
        e.setInterestRate(d.interestRate());
        e.setMaturityDate(d.maturityDate());
        return e;
    }

    // Deposit Transaction
    private DepositTransactionDTO toDepositTransactionDTO(DepositTransactionEntity e) {
        return new DepositTransactionDTO(e.getId(), e.getStartDate(), e.getEndDate(),
                e.getAmount(), e.getCurrentBalance(), e.getMode(), e.getNarration(),
                e.getReference(), e.getTransactionId(), e.getTransactionTimestamp(),
                e.getType(), e.getValueDate());
    }

    private DepositTransactionEntity toDepositTransactionEntity(DepositTransactionDTO d) {
        DepositTransactionEntity e = new DepositTransactionEntity();
        e.setId(d.id());
        e.setStartDate(d.startDate());
        e.setEndDate(d.endDate());
        e.setAmount(d.amount());
        e.setCurrentBalance(d.currentBalance());
        e.setMode(d.mode());
        e.setNarration(d.narration());
        e.setReference(d.reference());
        e.setTransactionId(d.transactionId());
        e.setTransactionTimestamp(d.transactionTimestamp());
        e.setType(d.type());
        e.setValueDate(d.valueDate());
        return e;
    }

    // Equity Profile
    private EquityProfileDTO toEquityProfileDTO(EquityProfileEntity e) {
        return new EquityProfileDTO(e.getId(), e.getAddress(), e.getDematId(), e.getDob(),
                e.getEmail(), e.getKycCompliance(), e.getLandline(), e.getMobile(),
                e.getName(), e.getNominee(), e.getPan());
    }

    private EquityProfileEntity toEquityProfileEntity(EquityProfileDTO d) {
        EquityProfileEntity e = new EquityProfileEntity();
        e.setId(d.id());
        e.setAddress(d.address());
        e.setDematId(d.dematId());
        e.setDob(d.dob());
        e.setEmail(d.email());
        e.setKycCompliance(d.kycCompliance());
        e.setLandline(d.landline());
        e.setMobile(d.mobile());
        e.setName(d.name());
        e.setNominee(d.nominee());
        e.setPan(d.pan());
        return e;
    }

    // Equity Summary
    private EquitySummaryDTO toEquitySummaryDTO(EquitySummaryEntity e) {
        return new EquitySummaryDTO(e.getId(), e.getCurrentValue(), e.getHoldingMode(),
                e.getIsin(), e.getIsinDescription(), e.getIssuerName(),
                e.getLastTradedPrice(), e.getUnits());
    }

    private EquitySummaryEntity toEquitySummaryEntity(EquitySummaryDTO d) {
        EquitySummaryEntity e = new EquitySummaryEntity();
        e.setId(d.id());
        e.setCurrentValue(d.currentValue());
        e.setHoldingMode(d.holdingMode());
        e.setIsin(d.isin());
        e.setIsinDescription(d.isinDescription());
        e.setIssuerName(d.issuerName());
        e.setLastTradedPrice(d.lastTradedPrice());
        e.setUnits(d.units());
        return e;
    }

    // Equity Transaction
    private EquityTransactionDTO toEquityTransactionDTO(EquityTransactionEntity e) {
        return new EquityTransactionDTO(e.getId(), e.getStartDate(), e.getEndDate(),
                e.getCompanyName(), e.getEquityCategory(), e.getExchange(), e.getIsin(),
                e.getIsinDescription(), e.getNarration(), e.getOrderId(), e.getRate(),
                e.getTransactionDateTime(), e.getTxnId(), e.getType(), e.getUnits());
    }

    private EquityTransactionEntity toEquityTransactionEntity(EquityTransactionDTO d) {
        EquityTransactionEntity e = new EquityTransactionEntity();
        e.setId(d.id());
        e.setStartDate(d.startDate());
        e.setEndDate(d.endDate());
        e.setCompanyName(d.companyName());
        e.setEquityCategory(d.equityCategory());
        e.setExchange(d.exchange());
        e.setIsin(d.isin());
        e.setIsinDescription(d.isinDescription());
        e.setNarration(d.narration());
        e.setOrderId(d.orderId());
        e.setRate(d.rate());
        e.setTransactionDateTime(d.transactionDateTime());
        e.setTxnId(d.txnId());
        e.setType(d.type());
        e.setUnits(d.units());
        return e;
    }

    // MF Profile
    private MFProfileDTO toMFProfileDTO(MFProfileEntity e) {
        return new MFProfileDTO(e.getId(), e.getAddress(), e.getDematId(), e.getDob(),
                e.getEmail(), e.getFolioNo(), e.getKycCompliance(), e.getLandline(),
                e.getMobile(), e.getName(), e.getNominee(), e.getPan());
    }

    private MFProfileEntity toMFProfileEntity(MFProfileDTO d) {
        MFProfileEntity e = new MFProfileEntity();
        e.setId(d.id());
        e.setAddress(d.address());
        e.setDematId(d.dematId());
        e.setDob(d.dob());
        e.setEmail(d.email());
        e.setFolioNo(d.folioNo());
        e.setKycCompliance(d.kycCompliance());
        e.setLandline(d.landline());
        e.setMobile(d.mobile());
        e.setName(d.name());
        e.setNominee(d.nominee());
        e.setPan(d.pan());
        return e;
    }

    // MF Summary
    private MFSummaryDTO toMFSummaryDTO(MFSummaryEntity e) {
        return new MFSummaryDTO(e.getId(), e.getCostValue(), e.getCurrentValue(),
                e.getFatcaStatus(), e.getAmc(), e.getAmfiCode(), e.getClosingUnits(),
                e.getFolioNo(), e.getIsin(), e.getIsinDescription(), e.getLienUnits(),
                e.getLockinUnits(), e.getNav(), e.getNavDate(), e.getRegistrar(),
                e.getSchemeCategory(), e.getSchemeCode(), e.getSchemeOption(),
                e.getSchemeTypes(), e.getUcc());
    }

    private MFSummaryEntity toMFSummaryEntity(MFSummaryDTO d) {
        MFSummaryEntity e = new MFSummaryEntity();
        e.setId(d.id());
        e.setCostValue(d.costValue());
        e.setCurrentValue(d.currentValue());
        e.setFatcaStatus(d.fatcaStatus());
        e.setAmc(d.amc());
        e.setAmfiCode(d.amfiCode());
        e.setClosingUnits(d.closingUnits());
        e.setFolioNo(d.folioNo());
        e.setIsin(d.isin());
        e.setIsinDescription(d.isinDescription());
        e.setLienUnits(d.lienUnits());
        e.setLockinUnits(d.lockinUnits());
        e.setNav(d.nav());
        e.setNavDate(d.navDate());
        e.setRegistrar(d.registrar());
        e.setSchemeCategory(d.schemeCategory());
        e.setSchemeCode(d.schemeCode());
        e.setSchemeOption(d.schemeOption());
        e.setSchemeTypes(d.schemeTypes());
        e.setUcc(d.ucc());
        return e;
    }

    // MF Transaction
    private MFTransactionDTO toMFTransactionDTO(MFTransactionEntity e) {
        return new MFTransactionDTO(e.getId(), e.getStartDate(), e.getEndDate(),
                e.getAmc(), e.getAmfiCode(), e.getAmount(), e.getIsin(),
                e.getIsinDescription(), e.getLockInDays(), e.getLockInFlag(),
                e.getMode(), e.getNarration(), e.getNav(), e.getNavDate(),
                e.getRegistrar(), e.getSchemeCode(), e.getSchemePlan(),
                e.getTransactionDate(), e.getTxnId(), e.getType(),
                e.getUcc(), e.getUnits());
    }

    private MFTransactionEntity toMFTransactionEntity(MFTransactionDTO d) {
        MFTransactionEntity e = new MFTransactionEntity();
        e.setId(d.id());
        e.setStartDate(d.startDate());
        e.setEndDate(d.endDate());
        e.setAmc(d.amc());
        e.setAmfiCode(d.amfiCode());
        e.setAmount(d.amount());
        e.setIsin(d.isin());
        e.setIsinDescription(d.isinDescription());
        e.setLockInDays(d.lockInDays());
        e.setLockInFlag(d.lockInFlag());
        e.setMode(d.mode());
        e.setNarration(d.narration());
        e.setNav(d.nav());
        e.setNavDate(d.navDate());
        e.setRegistrar(d.registrar());
        e.setSchemeCode(d.schemeCode());
        e.setSchemePlan(d.schemePlan());
        e.setTransactionDate(d.transactionDate());
        e.setTxnId(d.txnId());
        e.setType(d.type());
        e.setUcc(d.ucc());
        e.setUnits(d.units());
        return e;
    }

    // Client Consent Mapping
    private ClientConsentMappingDTO toClientConsentDTO(ClientConsentMappingEntity e) {
        return new ClientConsentMappingDTO(e.getId(), e.getClientCode(), e.getPan(),
                e.getDob(), e.getEmail(), e.getRequestId(), e.getConsentHandle(),
                e.getState(), e.getConsentStatus(), e.getDataFetchStatus());
    }

    private ClientConsentMappingEntity toClientConsentEntity(ClientConsentMappingDTO d) {
        ClientConsentMappingEntity e = new ClientConsentMappingEntity();
        e.setId(d.id());
        e.setClientCode(d.clientCode());
        e.setPan(d.pan());
        e.setDob(d.dob());
        e.setEmail(d.email());
        e.setRequestId(d.requestId());
        e.setConsentHandle(d.consentHandle());
        e.setState(d.state());
        e.setConsentStatus(d.consentStatus());
        e.setDataFetchStatus(d.dataFetchStatus());
        return e;
    }

    // Client Consent Mapping Hist
    private ClientConsentMappingHistDTO toClientConsentHistDTO(ClientConsentMappingHistEntity e) {
        return new ClientConsentMappingHistDTO(e.getId(), e.getClientCode(), e.getPan(),
                e.getDob(), e.getEmail(), e.getRequestId(), e.getConsentHandle(),
                e.getState(), e.getConsentStatus(), e.getDataFetchStatus(),
                e.getLastUpdatedTime());
    }

    private ClientConsentMappingHistEntity toClientConsentHistEntity(ClientConsentMappingHistDTO d) {
        ClientConsentMappingHistEntity e = new ClientConsentMappingHistEntity();
        e.setId(d.id());
        e.setClientCode(d.clientCode());
        e.setPan(d.pan());
        e.setDob(d.dob());
        e.setEmail(d.email());
        e.setRequestId(d.requestId());
        e.setConsentHandle(d.consentHandle());
        e.setState(d.state());
        e.setConsentStatus(d.consentStatus());
        e.setDataFetchStatus(d.dataFetchStatus());
        e.setLastUpdatedTime(d.lastUpdatedTime());
        return e;
    }
}
