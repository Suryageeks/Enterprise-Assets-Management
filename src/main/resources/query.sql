-- Fetch the Initial Status
select
    p.asset_id,
    p.asset_name,
    p.branch_name,
    p.depriciation_rate,
    p.depriciation_time,
    p.depriciation_value,
    p.price,
    p.solid,
    'PM' AS status
from physical_assets_register p
         join
     assets_sol_mapper asm
     on asm.asset_id = p.asset_id
         and asm.sol_id = p.solid
         and asm.month = EXTRACT(MONTH FROM p.created_at)
         and asm.year = EXTRACT(YEAR FROM p.created_at)
order by
    p.asset_id ASC;